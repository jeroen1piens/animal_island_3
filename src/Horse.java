import java.util.Map;

public class Horse extends Animal {
    public Horse(double fedLevel) {
        super(fedLevel);
        setWeight(400);
        setRequiredFoodWeight(60);
        setCatchMap(CatchMaps.HORSECATCHMAP);
        setMinBreedingFoodlevel(20);
        setMaxTilesPerTurn(4);
    }
}
