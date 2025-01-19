package simulation;

import java.util.Map;

public class Boa extends Animal {
    public Boa(double fedLevel) {
        super(fedLevel);
        setWeight(15);
        setRequiredFoodWeight(3);
        setCatchMap(CatchMaps.BOACATCHMAP);
        setMinBreedingFoodlevel(20);
        setMaxTilesPerTurn(1);
    }
}
