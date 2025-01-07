import java.util.Map;

public class Buffalo extends Animal {
    private double weight = 700;
    private double requiredFoodWeight = 100;
    private Map<String, Integer> catchMap = CatchMaps.BUFFALOCATCHMAP;
    private static final int MIN_BREEDING_FOODLEVEL = 20;
    private static final int MAX_TILES_PER_TURN = 3;

    public Buffalo(double fedLevel) {
        super(fedLevel);
    }

    @Override
    public double getWeight() {
        return weight;
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
    public int getMinBreedingFoodlevel() {
        return MIN_BREEDING_FOODLEVEL;
    }

    @Override
    public int getMaxTilesPerTurn() {
        return MAX_TILES_PER_TURN;
    }
}
