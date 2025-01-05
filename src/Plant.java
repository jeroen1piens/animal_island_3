public class Plant extends Organism {
    private double weight = 1;

    @Override
    public void run() {
        grow();
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public boolean grow() {
        Plant plant = getIslandSimulator().createPlant();
        boolean successfull = plant.setInitialPosition(getIslandSimulator(), getXCoordinate(), getYCoordinate());
        return successfull;
    }
}
