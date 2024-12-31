import java.util.List;

public abstract class Organism implements Runnable {
    private IslandSimulator islandSimulator;
    private int xCoordinate;
    private int yCoordinate;

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }
    public IslandSimulator getIslandSimulator() {
        return islandSimulator;
    }

    public boolean setInitialPosition(IslandSimulator islandSimulator, int newXCoordinate, int newYCoordinate) {
        this.islandSimulator = islandSimulator;
        boolean successful = islandSimulator.addOrganism(this, newXCoordinate, newYCoordinate);
        if (successful) {
            this.xCoordinate = newXCoordinate;
            this.yCoordinate = newYCoordinate;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean changePosition(int newXCoordinate, int newYCoordinate) {
        if (this.xCoordinate == newXCoordinate && this.yCoordinate == newYCoordinate) {
            return true;
        }
        boolean successful = islandSimulator.addOrganism(this, newXCoordinate, newYCoordinate);
        if (successful) {
            islandSimulator.removeOrganism(this, this.xCoordinate, this.yCoordinate);
            this.xCoordinate = newXCoordinate;
            this.yCoordinate = newYCoordinate;
            return true;
        }
        else {
            return false;
        }
    }
}
