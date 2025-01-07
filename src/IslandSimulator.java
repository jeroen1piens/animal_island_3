import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IslandSimulator {

    private Tile[][] island;

    private int horizontalLengthIsland;
    private int verticalLengthIsland;
    private OrganismFactory organismFactory;
    private ScheduledExecutorService scheduledExecutorService;
    private Analytics analytics;

    public IslandSimulator() {
        organismFactory = new OrganismFactory();
        island = createIsland(3,3);
        randomlySpreadOrganisms(createInitialOrganisms());
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

        return island[yCoordinate][xCoordinate];
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
            return tile.addOrganism(organism);
        }
    }

    public void removeOrganism(Organism organism, int xCoordinate, int yCoordinate) {
        Tile tile = getTile(xCoordinate, yCoordinate);
        tile.removeOrganism(organism);
    }

    public Set<Organism> retrieveSpecificOrganisms(Class<? extends Organism> clazz, int xCoordinate, int yCoordinate) {
        return getTile(xCoordinate, yCoordinate).retrieveSpecificOrganisms(clazz);
    }

    public List<Organism> retrieveAllOrganisms() {
        List<Organism> organismList = new ArrayList<>();
        for (int i = 0; i < verticalLengthIsland; i++) {
            for (int j = 0; j < horizontalLengthIsland ; j++) {
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

    public void simulate(int turns) {
        for (int i = 0; i < turns; i++) {
            scheduledExecutorService = Executors.newScheduledThreadPool(3);
            scheduleNextTurn(retrieveAllOrganisms(), scheduledExecutorService);
            scheduledExecutorService.shutdown();
            while(!scheduledExecutorService.isTerminated()) {
                try{
                    Thread.sleep(250);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(retrieveAllOrganisms());
            System.out.println("Organisms count: " + retrieveAllOrganisms().size());
            analytics.updateAllOrganismsCollection(retrieveAllOrganisms());
            System.out.println(analytics.getOrganismsCountMap());
        }
    }

    public List<Organism> createInitialOrganisms() {
        List<Organism> initialOrganismsList = new ArrayList<>();
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
