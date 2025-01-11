import java.util.Map;

public class Fox extends Animal {
    public Fox(double fedLevel) {
        super(fedLevel);
        setWeight(8);
        setRequiredFoodWeight(2);
        setCatchMap(CatchMaps.FOXCATCHMAP);
        setMinBreedingFoodlevel(20);
        setMaxTilesPerTurn(2);
    }
}