import java.util.List;
import java.util.NoSuchElementException;

public abstract class Organism implements Runnable {
    private IslandSimulator islandSimulator;
    private int xCoordinate;
    private int yCoordinate;
    private volatile boolean alive = true;

    public Organism() {
        islandSimulator.register(this);
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

    public void die() {
        alive = false;
        islandSimulator.removeOrganism(this, xCoordinate, yCoordinate);
        xCoordinate = -1;
        yCoordinate = -1;
    }


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
}
