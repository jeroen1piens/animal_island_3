package simulation;

import simulation.IslandSimulator;

import java.util.NoSuchElementException;

public abstract class Organism implements Runnable {
    private IslandSimulator islandSimulator;
    private int xCoordinate;
    private int yCoordinate;
    private volatile boolean alive = true;
    protected volatile boolean newBorn = true;

    public Organism() {
    }

    public IslandSimulator getIslandSimulator() {
        return islandSimulator;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public abstract double getWeight();

    public boolean isAlive() {
        return alive;
    }
    public boolean isNewBorn() {
        return newBorn;
    }

    //Makes the organism die. The organism will be removed from the islandSimulator.
    public void die() {
        alive = false;
        islandSimulator.removeOrganism(this, xCoordinate, yCoordinate);
        xCoordinate = -1;
        yCoordinate = -1;
    }

    //Method by which the initial position of the organism can be set
    public boolean setInitialPosition(IslandSimulator islandSimulator, int newXCoordinate, int newYCoordinate) {
        this.islandSimulator = islandSimulator;
        boolean successful = islandSimulator.addOrganism(this, newXCoordinate, newYCoordinate);
        if (successful) {
            this.xCoordinate = newXCoordinate;
            this.yCoordinate = newYCoordinate;
            if (!getIslandSimulator().validateCoordinates(this)) {
                throw new NoSuchElementException("There is an issue with the coordinates of organism " + this.toString() + " at setting the initial position!");
            }
            return true;
        }
        return false;
    }

    //Method by which the position of the organism can be changed
    public boolean changePosition(int newXCoordinate, int newYCoordinate) {
        if (this.xCoordinate == newXCoordinate && this.yCoordinate == newYCoordinate) {
            if (!getIslandSimulator().validateCoordinates(this)) {
                throw new NoSuchElementException("There is an issue with the coordinates of organism " + this.toString()
                        + " at changing the previous position from " + "X=" + xCoordinate + ",Y=" + yCoordinate + ", to newX=" + newXCoordinate + ", newY=" + newYCoordinate);
            }
            return true;
        }
        boolean successful = islandSimulator.addOrganism(this, newXCoordinate, newYCoordinate);
        if (successful) {
            islandSimulator.removeOrganism(this, this.xCoordinate, this.yCoordinate);
            this.xCoordinate = newXCoordinate;
            this.yCoordinate = newYCoordinate;
            if (!getIslandSimulator().validateCoordinates(this)) {
                throw new NoSuchElementException("There is an issue with the coordinates of organism " + this.toString()
                        + " at changing the previous position from " + "X=" + xCoordinate + ",Y=" + yCoordinate + ", to newX=" + newXCoordinate + ", newY=" + newYCoordinate);
            }
            return true;
        } else {
            if (!getIslandSimulator().validateCoordinates(this)) {
                throw new NoSuchElementException("There is an issue with the coordinates of organism " + this.toString() + " the islandsimulator didn't allow to change the position from " + "X=" + xCoordinate + ",Y=" + yCoordinate + ", to newX=" + newXCoordinate + ", newY=" + newYCoordinate);
            }
            return false;
        }
    }

    //Method can be used by a simulator to reset certain parameters for the next turn
    public abstract void prepareForNextTurn();
}

