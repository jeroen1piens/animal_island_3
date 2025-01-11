import java.util.Map;

public class Goat extends Animal {
    public Goat(double fedLevel) {
        super(fedLevel);
        setWeight(60);
        setRequiredFoodWeight(10);
        setCatchMap(CatchMaps.GOATCATCHMAP);
        setMinBreedingFoodlevel(20);
        setMaxTilesPerTurn(3);
    }
}