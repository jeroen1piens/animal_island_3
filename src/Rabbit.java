import java.util.Map;

public class Rabbit extends Animal {
    public Rabbit(double fedLevel) {
        super(fedLevel);
        setWeight(2);
        setRequiredFoodWeight(0.45);
        setCatchMap(CatchMaps.RABBITCATCHMAP);
        setMinBreedingFoodlevel(20);
        setMaxTilesPerTurn(2);
    }
}
