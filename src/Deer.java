import java.util.Map;

public class Deer extends Animal {
    private double weight = 300;
    private double requiredFoodWeight = 50;
    private Map<String, Integer> catchMap = CatchMaps.DEERCATCHMAP;
    private static final int MIN_BREEDING_FOODLEVEL = 20;
    private static final int MAX_TILES_PER_TURN = 4;

    public Deer(double fedLevel) {
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
