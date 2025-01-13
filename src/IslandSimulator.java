import java.util.*;
import java.util.concurrent.*;

public class IslandSimulator {

    private Tile[][] island;

    private int horizontalLengthIsland;
    private int verticalLengthIsland;
    private OrganismFactory organismFactory;
    private ScheduledExecutorService scheduledExecutorService;
    private Analytics analytics;

    public IslandSimulator() {
        organismFactory = new OrganismFactory();
        island = createIsland(20, 20);
        randomlySpreadOrganisms(createAllInitialOrganisms());
        analytics = new Analytics();
    }

    public static void main(String[] args) {
        IslandSimulator islandSimulator = new IslandSimulator();
        islandSimulator.simulate(100);
    }

    public Tile[][] createIsland(int horizontalLengthIsland, int verticalLengthIsland) {
        this.horizontalLengthIsland = horizontalLengthIsland;
        this.verticalLengthIsland = verticalLengthIsland;

        island = new Tile[verticalLengthIsland][horizontalLengthIsland];
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                island[i][j] = new Tile();
            }
        }
        return island;
    }

    public Tile getTile(int xCoordinate, int yCoordinate) {
        if(xCoordinate >= 0 && xCoordinate < horizontalLengthIsland && yCoordinate >= 0 && yCoordinate < verticalLengthIsland) {
            return island[yCoordinate][xCoordinate];
        }
        else {
            throw new IllegalArgumentException("No tile exists with coordinates X=" + xCoordinate + ", Y=" + yCoordinate + ". The horizontal length of the island is = " + getHorizontalLengthIsland() + ", the vertical length of the island is = " + getVerticalLengthIsland());
        }
    }

    public int getHorizontalLengthIsland() {
        return horizontalLengthIsland;
    }

    public int getVerticalLengthIsland() {
        return verticalLengthIsland;
    }

    public boolean addOrganism(Organism organism, int xCoordinate, int yCoordinate) {
        Tile tile = getTile(xCoordinate, yCoordinate);
        synchronized (tile) {
            boolean successful = tile.addOrganism(organism);
            return successful;
        }
    }

    public void removeOrganism(Organism organism, int xCoordinate, int yCoordinate) {
        Tile tile = getTile(xCoordinate, yCoordinate);
        tile.removeOrganism(organism);
    }

    public boolean validateCoordinates(Organism organism) {
        if (getTile(organism.getXCoordinate(), organism.getYCoordinate()).contains(organism)) {
            return true;
        }
        else {
            return false;
        }
    }

    public Set<Organism> retrieveSpecificOrganisms(Class<? extends Organism> clazz, int xCoordinate, int yCoordinate) {
        return getTile(xCoordinate, yCoordinate).retrieveSpecificOrganisms(clazz);
    }

    public List<Organism> retrieveAllOrganisms() {
        List<Organism> organismList = new ArrayList<>();
        for (int i = 0; i < verticalLengthIsland; i++) {
            for (int j = 0; j < horizontalLengthIsland; j++) {
                organismList.addAll(retrieveAllOrganisms(j, i));
            }
        }
        return organismList;
    }

    public List<Organism> retrieveAllOrganisms(int xCoordinate, int yCoordinate) {
        List<Organism> organismList = new ArrayList<>();
        Tile tile = getTile(xCoordinate, yCoordinate);
        organismList.addAll(tile.retrieveAllOrganisms());
        return organismList;
    }

    public void scheduleNextTurn(Collection<Organism> organisms, ScheduledExecutorService scheduledExecutorService) {
        for (Organism organism : organisms) {
            scheduledExecutorService.schedule(organism, 10, TimeUnit.MILLISECONDS);
        }
    }

    public void simulateInOneLoop(int turns) {
        for (int i = 0; i < turns; i++) {
            for (Organism organism : retrieveAllOrganisms()) {
                organism.run();
            }
            //System.out.println(retrieveAllOrganisms());
            System.out.println("Organisms count: " + retrieveAllOrganisms().size());
            analytics.updateAllOrganismsCollection(retrieveAllOrganisms());
            System.out.println("Plant: " + analytics.getOrganismsCountMap().get("Plant"));
            System.out.println("Sheep: " + analytics.getOrganismsCountMap().get("Sheep"));
            System.out.println("Wolf: " + analytics.getOrganismsCountMap().get("Wolf"));
            System.out.println("Bear: " + analytics.getOrganismsCountMap().get("Bear"));
            notifyForNextTurn();
        }

    }

    public void simulate(int turns) {
        for (int i = 0; i < turns; i++) {
            scheduledExecutorService = Executors.newScheduledThreadPool(3);
            scheduleNextTurn(retrieveAllOrganisms(), scheduledExecutorService);
            scheduledExecutorService.shutdown();
            while (!scheduledExecutorService.isTerminated()) {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Organisms count: " + retrieveAllOrganisms().size());
            analytics.updateAllOrganismsCollection(retrieveAllOrganisms());
            System.out.println("Plant: " + analytics.getOrganismsCountMap().get("Plant"));
            System.out.println("Sheep: " + analytics.getOrganismsCountMap().get("Sheep"));
            System.out.println("Wolf: " + analytics.getOrganismsCountMap().get("Wolf"));
            System.out.println("Bear: " + analytics.getOrganismsCountMap().get("Bear"));

            notifyForNextTurn();
        }
    }

    private void notifyForNextTurn() {
        retrieveAllOrganisms().stream()
                .filter(organism -> organism instanceof Animal)
                .map(organism -> (Animal) organism)
                .forEach(animal -> animal.updateForNextTurn());
    }

    public List<Organism> createAllInitialOrganisms() {
        List<Organism> initialOrganismsList = new ArrayList<>();

        for (int i = 0; i < InitialOrganisms.BEAR_COUNT; i++) {
            initialOrganismsList.add(createAnimal(Bear.class, 100));
        }

        for (int i = 0; i < InitialOrganisms.PLANT_COUNT; i++) {
            initialOrganismsList.add(createPlant());
        }
        for (int i = 0; i < InitialOrganisms.SHEEP_COUNT; i++) {
            initialOrganismsList.add(createSheep(100));
        }
        for (int i = 0; i < InitialOrganisms.WOLF_COUNT; i++) {
            initialOrganismsList.add(createWolf(100));
        }
        return initialOrganismsList;
    }

    public Plant createPlant() {
        return organismFactory.createPlant();
    }

    public Wolf createWolf(double fedLevel) {
        return organismFactory.createWolf(fedLevel);
    }

    public Sheep createSheep(double fedLevel) {
        return organismFactory.createSheep(fedLevel);
    }

    public Animal createAnimal(Class<? extends Animal> clazz, int fedLevel) {
        return organismFactory.createAnimal(clazz, fedLevel);
    }

    public void randomlySpreadOrganisms(List<Organism> organisms) {
        Random random = new Random();
        int randomX;
        int randomY;
        for (Organism organism : organisms) {
            boolean successFullPositioning = false;
            while (!successFullPositioning) {
                randomX = random.nextInt(0, horizontalLengthIsland);
                randomY = random.nextInt(0, verticalLengthIsland);
                successFullPositioning = organism.setInitialPosition(this, randomX, randomY);
            }
        }
    }
}
