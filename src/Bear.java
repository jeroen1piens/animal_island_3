import java.util.Map;

public class Bear extends Animal {
    public Bear(double fedLevel) {
        super(fedLevel);
        setWeight(500);
        setRequiredFoodWeight(80);
        setCatchMap(CatchMaps.BEARCATCHMAP);
        setMinBreedingFoodlevel(20);
        setMaxTilesPerTurn(2);
    }

    @Override
    public String toString() {
        return "Bear{" +
                "weight=" + getWeight() +
                ", requiredFoodWeight=" + getRequiredFoodWeight() +
                ", catchMap=" + getCatchMap() +
                '}';
    }
}
