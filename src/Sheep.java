import java.util.Map;

public class Sheep extends Animal {
    private double weight = 70;
    private double requiredFoodWeight = 15;
    private Map<String, Integer> catchMap = CatchMaps.SHEEPCATCHMAP;

    @Override
    public void run() {
        move(3);
        collectFood();
        reduceFedLevel();
        dieIfUnderfed();
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
}
