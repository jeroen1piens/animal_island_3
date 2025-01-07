import java.util.Map;

public class Horse extends Animal {
    private double weight = 400;
    private double requiredFoodWeight = 60;
    private Map<String, Integer> catchMap = CatchMaps.HORSECATCHMAP;
    private static final int MIN_BREEDING_FOODLEVEL = 20;
    private static final int MAX_TILES_PER_TURN = 4;

    public Horse(double fedLevel) {
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
