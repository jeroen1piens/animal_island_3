import java.util.Map;

public class Eagle extends Animal {
    private double weight = 6;
    private double requiredFoodWeight = 1;
    private Map<String, Integer> catchMap = CatchMaps.EAGLECATCHMAP;
    private static final int MIN_BREEDING_FOODLEVEL = 20;
    private static final int MAX_TILES_PER_TURN = 3;

    public Eagle(double fedLevel) {
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
