import java.util.Map;

public class Wolf extends Animal {
    private double weight = 50;
    private double requiredFoodWeight = 8;
    private Map<String, Integer> catchMap = CatchMaps.WOLFCATCHMAP;
    private static final int MIN_BREEDING_FOODLEVEL = 20;
    private static final int MAX_TILES_PER_TURN = 3;


    public Wolf(double fedLevel) {
        super(fedLevel);
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

    @Override
    public double getWeight() {
        return weight;
    }


}
