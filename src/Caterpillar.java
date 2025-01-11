import java.util.Map;

public class Caterpillar extends Animal {
    public Caterpillar(double fedLevel) {
        super(fedLevel);
        setWeight(0.01);
        setRequiredFoodWeight(0);
        setCatchMap(CatchMaps.CATERPILLARCATCHMAP);
        setMinBreedingFoodlevel(20);
        setMaxTilesPerTurn(0);
    }
}
