import java.util.Map;

public class Sheep extends Animal {
    private double weight = 70;
    private double requiredFoodWeight = 15;
    private Map<String, Integer> catchMap = CatchMaps.SHEEPCATCHMAP;

    public Sheep() {

    }

    public Sheep(double fedLevel) {
        super(fedLevel);
    }

    @Override
    public void run() {
        move(3);
        collectFood();
        reduceFedLevel();
        dieIfUnderfed();
        breed();
    }

    @Override
    protected double getRequiredFoodWeight() {
        return requiredFoodWeight;
    }

    @Override
    public Map<String, Integer> getCatchMap() {
        return catchMap;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean breed() {
        if (getFedLevel() <= 20) {
            return false;
        }
        else {
            Sheep sheep = getIslandSimulator().createSheep(getFedLevel()-20);
            boolean successfull = sheep.setInitialPosition(getIslandSimulator(), getXCoordinate(), getYCoordinate());
            return successfull;
        }
    }
}
