import java.util.Map;

public class Mouse extends Animal {
    public Mouse(double fedLevel) {
        super(fedLevel);
        setWeight(0.05);
        setRequiredFoodWeight(0.01);
        setCatchMap(CatchMaps.MOUSECATCHMAP);
        setMinBreedingFoodlevel(20);
        setMaxTilesPerTurn(1);
    }
}
