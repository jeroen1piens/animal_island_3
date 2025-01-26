package simulation;

import controller.AnalysisController;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class IslandSimulator {

    private Tile[][] island;
    private int turn = 0;
    private int horizontalLengthIsland;
    private int verticalLengthIsland;
    private OrganismFactory organismFactory;
    private ScheduledExecutorService scheduledExecutorService;
    private AnalysisController analysisController;

    public IslandSimulator() {
        organismFactory = new OrganismFactory();
        island = createIsland(StartSettings.getHorizontalLengthIsland(), StartSettings.getVerticallengthIsland());
        randomlySpreadOrganisms(createAllInitialOrganisms());
        turn = 0;
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

    public void setAnalysisController(AnalysisController analysisController) {
        this.analysisController = analysisController;
    }

    //Adds an organism on a tile
    public boolean addOrganism(Organism organism, int xCoordinate, int yCoordinate) {
        Tile tile = getTile(xCoordinate, yCoordinate);
        synchronized (tile) {
            boolean successful = tile.addOrganism(organism);
            return successful;
        }
    }

    //Removes an organism from a tile
    public void removeOrganism(Organism organism, int xCoordinate, int yCoordinate) {
        Tile tile = getTile(xCoordinate, yCoordinate);
        tile.removeOrganism(organism);
    }

    //Informs if the organism is present on the tile with the coordinates the organism holds
    public boolean validateCoordinates(Organism organism) {
        if (getTile(organism.getXCoordinate(), organism.getYCoordinate()).contains(organism)) {
            return true;
        }
        else {
            return false;
        }
    }



    //Retrieves all organisms from all classes and from all tiles
    public List<Organism> retrieveAllIslandOrganisms() {
        List<Organism> organismList = new ArrayList<>();
        for (int i = 0; i < verticalLengthIsland; i++) {
            for (int j = 0; j < horizontalLengthIsland; j++) {
                organismList.addAll(retrieveAllTileOrganisms(j, i));
            }
        }
        return organismList;
    }

    //Retrieves all organisms from all classes from the tile with the specified coordinates
    public List<Organism> retrieveAllTileOrganisms(int xCoordinate, int yCoordinate) {
        List<Organism> organismList = new ArrayList<>();
        Tile tile = getTile(xCoordinate, yCoordinate);
        organismList.addAll(tile.retrieveAllOrganisms());
        return organismList;
    }

    //Retrieves all organisms from a certain class from the tile with the specified coordinates
    public Set<Organism> retrieveSpecificOrganisms(Class<? extends Organism> clazz, int xCoordinate, int yCoordinate) {
        return getTile(xCoordinate, yCoordinate).retrieveSpecificOrganisms(clazz);
    }


    //Schedules each organism in the specified collection to be run as an individual thread
    public void scheduleNextTurn(Collection<Organism> organisms, ScheduledExecutorService scheduledExecutorService) {
        for (Organism organism : organisms) {
            scheduledExecutorService.schedule(organism, 10, TimeUnit.MILLISECONDS);
        }
    }

    //Start simulating the actions of the organisms on the island
    public void simulate() {
        for (int i = 0; i < StartSettings.getTurnCount(); i++) {
            turn++;
            scheduledExecutorService = Executors.newScheduledThreadPool(1);
            Set<Organism> startTurnOrganisms = retrieveAllIslandOrganisms().stream().collect(Collectors.toSet());
            prepareForNextTurn(startTurnOrganisms);
            scheduleNextTurn(startTurnOrganisms, scheduledExecutorService);
            scheduledExecutorService.shutdown();
            while (!scheduledExecutorService.isTerminated()) {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            analysisController.updateCurrentOrganisms(turn, startTurnOrganisms);
        }
    }

    //Helper method of the simulate method. Makes that certain parameters (e.g. newBorn, hasMate) are reset for the next turn.
    private void prepareForNextTurn(Collection<Organism> organisms) {
        for (Organism organism : organisms) {
            organism.prepareForNextTurn();
        }
    }

    //Helper method to the constructor. Creates the initial organisms as specified in the startSettings.
    private List<Organism> createAllInitialOrganisms() {
        List<Organism> initialOrganismsList = new ArrayList<>();

        for (int i = 0; i < StartSettings.getBearCount(); i++) {
            initialOrganismsList.add(organismFactory.createAnimal(Bear.class, 100));
        }

        for (int i = 0; i < StartSettings.getBoaCount(); i++) {
            initialOrganismsList.add(organismFactory.createAnimal(Boa.class, 100));
        }

        for (int i = 0; i < StartSettings.getBoarCount(); i++) {
            initialOrganismsList.add(organismFactory.createAnimal(Boar.class, 100));
        }
        for (int i = 0; i < StartSettings.getBuffaloCount(); i++) {
            initialOrganismsList.add(organismFactory.createAnimal(Buffalo.class, 100));
        }
        for (int i = 0; i < StartSettings.getCaterpillarCount(); i++) {
            initialOrganismsList.add(organismFactory.createAnimal(Caterpillar.class, 100));
        }
        for (int i = 0; i < StartSettings.getDeerCount(); i++) {
            initialOrganismsList.add(organismFactory.createAnimal(Deer.class, 100));
        }

        for (int i = 0; i < StartSettings.getDuckCount(); i++) {
            initialOrganismsList.add(organismFactory.createAnimal(Duck.class, 100));
        }

        for (int i = 0; i < StartSettings.getEagleCount(); i++) {
            initialOrganismsList.add(organismFactory.createAnimal(Eagle.class, 100));
        }

        for (int i = 0; i < StartSettings.getFoxCount(); i++) {
            initialOrganismsList.add(organismFactory.createAnimal(Fox.class, 100));
        }

        for (int i = 0; i < StartSettings.getGoatCount(); i++) {
            initialOrganismsList.add(organismFactory.createAnimal(Goat.class, 100));
        }

        for (int i = 0; i < StartSettings.getHorseCount(); i++) {
            initialOrganismsList.add(organismFactory.createAnimal(Horse.class, 100));
        }

        for (int i = 0; i < StartSettings.getMouseCount(); i++) {
            initialOrganismsList.add(organismFactory.createAnimal(Mouse.class, 100));
        }

        for (int i = 0; i < StartSettings.getPlantCount(); i++) {
            initialOrganismsList.add(organismFactory.createPlant());
        }

        for (int i = 0; i < StartSettings.getRabbitCount(); i++) {
            initialOrganismsList.add(organismFactory.createAnimal(Rabbit.class, 100));
        }

        for (int i = 0; i < StartSettings.getSheepCount(); i++) {
            initialOrganismsList.add(organismFactory.createAnimal(Sheep.class, 100));
        }
        for (int i = 0; i < StartSettings.getWolfCount(); i++) {
            initialOrganismsList.add(organismFactory.createAnimal(Wolf.class,100));
        }
        return initialOrganismsList;
    }

    //Helper method to the constructor. Randomly spreads the organisms on the island.
    private void randomlySpreadOrganisms(List<Organism> organisms) {
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
