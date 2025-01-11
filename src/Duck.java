import java.util.Map;

public class Duck extends Animal {
    public Duck(double fedLevel) {
        super(fedLevel);
        setWeight(1);
        setRequiredFoodWeight(0.15);
        setCatchMap(CatchMaps.DUCKCATCHMAP);
        setMinBreedingFoodlevel(20);
        setMaxTilesPerTurn(4);
    }
}