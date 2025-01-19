package simulation;

import java.util.Map;

public class Deer extends Animal {
    public Deer(double fedLevel) {
            super(fedLevel);
            setWeight(300);
            setRequiredFoodWeight(50);
            setCatchMap(CatchMaps.DEERCATCHMAP);
            setMinBreedingFoodlevel(20);
            setMaxTilesPerTurn(4);
    }
}
