import java.util.Map;

public class Wolf extends Animal {
    public Wolf(double fedLevel) {
        super(fedLevel);
        setWeight(50);
        setRequiredFoodWeight(8);
        setCatchMap(CatchMaps.WOLFCATCHMAP);
        setMinBreedingFoodlevel(20);
        setMaxTilesPerTurn(3);
    }
}
