import java.util.Map;

public class Boa extends Animal {
    private double weight = 15;
    private double requiredFoodWeight = 3;
    private Map<String, Integer> catchMap = CatchMaps.BOACATCHMAP;
    private static final int MIN_BREEDING_FOODLEVEL = 20;
    private static final int MAX_TILES_PER_TURN = 1;

    public Boa(double fedLevel) {
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
