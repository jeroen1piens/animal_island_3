package simulation;

import simulation.IslandSimulator;

import java.util.concurrent.ThreadLocalRandom;

public class Plant extends Organism {
    private double weight = 1;
    private static final double STAY_LOCAL_PROBABILITY = 1.00;
    private static final double PROCREATE_PROBABILITY = 0.90;
    private OrganismFactory organismFactory = new OrganismFactory();

    //Method can be used by a simulator to run the plant as an individual thread
    @Override
    public void run() {
        synchronized (this) {
            if (isAlive()) {
                grow();
            }
        }
    }

    @Override
    public double getWeight() {
        return weight;
    }

    //Method can be used by a simulator to reset variables for the next turn
    @Override
    public void prepareForNextTurn() {
        newBorn = false;
    }

    //Method by which the plant can procreate
    public boolean grow() {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 100);
        if (randomNumber < PROCREATE_PROBABILITY*100) {
            Plant plant = organismFactory.createPlant();
            IslandSimulator islandSimulator = getIslandSimulator();
            boolean successfull = plant.setInitialPosition(islandSimulator, getXCoordinate(), getYCoordinate());
            return successfull;
        }
        return false;
    }
}
