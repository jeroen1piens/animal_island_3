import java.util.Map;

public class Sheep extends Animal {
    public Sheep(double fedLevel) {
        super(fedLevel);
        setWeight(70);
        setRequiredFoodWeight(15);
        setCatchMap(CatchMaps.SHEEPCATCHMAP);
        setMinBreedingFoodlevel(20);
        setMaxTilesPerTurn(3);
    }
}
