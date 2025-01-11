import java.util.Map;

public class Eagle extends Animal {
    public Eagle(double fedLevel) {
        super(fedLevel);
        setWeight(400);
        setRequiredFoodWeight(6);
        setCatchMap(CatchMaps.EAGLECATCHMAP);
        setMinBreedingFoodlevel(20);
        setMaxTilesPerTurn(3);
    }
}