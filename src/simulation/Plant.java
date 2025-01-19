package simulation;

import simulation.IslandSimulator;

import java.util.concurrent.ThreadLocalRandom;

public class Plant extends Organism {
    private double weight = 1;
    private static final double STAY_LOCAL_PROBABILITY = 0.90;
    private static final double PROCREATE_PROBABILITY = 0.70;
    private OrganismFactory organismFactory = new OrganismFactory();

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

    public boolean grow() {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 100);
        if (randomNumber < PROCREATE_PROBABILITY*100) {
            Plant plant = organismFactory.createPlant();
            int nextXCoordinate = chooseNextXCoordinate();
            int nextYCoordinate = chooseNextYCoordinate();
            IslandSimulator islandSimulator = getIslandSimulator();
            boolean successfull = plant.setInitialPosition(islandSimulator, nextXCoordinate, nextYCoordinate);
            return successfull;
        }
        return false;
    }

    private int chooseNextXCoordinate() {
        int number = ThreadLocalRandom.current().nextInt(0, 100);
        if (getIslandSimulator().getHorizontalLengthIsland() == 1) {
            return getXCoordinate();
        }
        if (number < Math.sqrt(STAY_LOCAL_PROBABILITY)*100) {
            return getXCoordinate();
        }
        else {
            int newXCoordinate = getXCoordinate();
            while(newXCoordinate == getXCoordinate()) {
                newXCoordinate = ThreadLocalRandom.current().nextInt(getXCoordinate() - 1 >= 0 ? getXCoordinate() - 1 : getXCoordinate(), getXCoordinate() + 1 < getIslandSimulator().getHorizontalLengthIsland() ? getXCoordinate() + 2 : getXCoordinate() + 1);
            }
            return newXCoordinate;
        }
    }

    private int chooseNextYCoordinate() {
        int number = ThreadLocalRandom.current().nextInt(0, 100);
        if (getIslandSimulator().getVerticalLengthIsland() == 1) {
            return getYCoordinate();
        }
        if (number < Math.sqrt(STAY_LOCAL_PROBABILITY)*100) {
            return getYCoordinate();
        }
        else {
            int newYCoordinate = getYCoordinate();
            while(newYCoordinate == getYCoordinate()) {
                newYCoordinate = ThreadLocalRandom.current().nextInt(getYCoordinate() > 0 ? getYCoordinate() - 1 : getYCoordinate(), getYCoordinate() < getIslandSimulator().getVerticalLengthIsland() - 1 ? getYCoordinate() + 2 : getYCoordinate() + 1);
            }
            return newYCoordinate;
        }
    }
}
