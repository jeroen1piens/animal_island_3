import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public abstract class Animal extends Organism {

    private double fedLevel = 100;

    protected abstract double getRequiredFoodWeight();
    public abstract Map<String, Integer> getCatchMap();

    private int chooseNextXCoordinate() {
        return ThreadLocalRandom.current().nextInt(getXCoordinate() - 1 >= 0 ? getXCoordinate() - 1 : getXCoordinate(), getXCoordinate() + 1 < getIslandSimulator().getHorizontalLengthIsland() ? getXCoordinate() + 2 : getXCoordinate() + 1);
    }
    private int chooseNextYCoordinate() {
        return ThreadLocalRandom.current().nextInt(getYCoordinate() - 1 >= 0 ? getYCoordinate() - 1 : getYCoordinate(), getYCoordinate() + 1 < getIslandSimulator().getVerticalLengthIsland() ? getYCoordinate() + 2 : getYCoordinate() + 1);
    }

    public void move(int tileCount) {
        for (int i = 0; i < tileCount; i++) {
            int nextXCoordinate = chooseNextXCoordinate();
            int nextYCoordinate = chooseNextYCoordinate();
            boolean successfull = changePosition(nextXCoordinate, nextYCoordinate);
            if (!successfull) {
                tileCount--;
            }
        }
    }

    private List<Organism> localiseAvailableFood() {
        List<Organism> allOrganismList = getIslandSimulator().retrieveAllOrganisms(getXCoordinate(), getYCoordinate());
        Collections.shuffle(allOrganismList);
        return allOrganismList.stream()
                .filter(organism -> getCatchMap().containsKey(organism.getClass().getSimpleName()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void collectFood() {
        for (Organism organism : localiseAvailableFood()) {
            if (fedLevel >= 100) {
                return;
            }
            synchronized(organism) {
                if (organism.isAlive()) {
                    boolean successFull = catchFood(organism);
                    if (successFull) {
                        fedLevel += (organism.getWeight() / getRequiredFoodWeight()) * 100;
                        if (fedLevel > 100) {
                            fedLevel = 100;
                        }
                    }
                }
            }
        }
    }
    private boolean catchFood(Organism organism) {
        int catchProbability = getCatchMap().get(organism.getClass().getSimpleName());
        int randomInt = ThreadLocalRandom.current().nextInt(0, 100);
        if (randomInt < catchProbability) {
            organism.die();
            return true;
            }
        else {
            return false;
        }
    }

    protected void reduceFedLevel() {
        fedLevel -= 20;
    }

    protected void dieIfUnderfed() {
        if(fedLevel <= 0) {
            this.die();
        }
    }
}
