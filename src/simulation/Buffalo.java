package simulation;

import java.util.Map;

public class Buffalo extends Animal {
    public Buffalo(double fedLevel) {
        super(fedLevel);
        setWeight(700);
        setRequiredFoodWeight(100);
        setCatchMap(CatchMaps.BUFFALOCATCHMAP);
        setMinBreedingFoodlevel(20);
        setMaxTilesPerTurn(3);
    }
}
