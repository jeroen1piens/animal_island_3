import java.util.Map;

public class Boar extends Animal {
    public Boar(double fedLevel) {
        super(fedLevel);
        setWeight(400);
        setRequiredFoodWeight(50);
        setCatchMap(CatchMaps.BOARCATCHMAP);
        setMinBreedingFoodlevel(20);
        setMaxTilesPerTurn(2);
    }
}

