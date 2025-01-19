import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public abstract class Animal extends Organism implements TurnObserver {
    private double fedLevel = 100;
    private volatile boolean hasMate;
    private double weight;
    private double requiredFoodWeight;
    private Map<String, Integer> catchMap;
    private int minBreedingFoodlevel;
    private int maxTilesPerTurn;
    private volatile boolean newBorn = true;
    private OrganismFactory organismFactory = new OrganismFactory();

    public Animal() {

    }

    public Animal (double fedLevel) {
        this.fedLevel = fedLevel;
    }

    public boolean isHasMate() {
        return hasMate;
    }
    public double getFedLevel() {
        return fedLevel;
    }

    public double getWeight() {
        return weight;
    }
    protected double getRequiredFoodWeight() {
        return requiredFoodWeight;
    };

    public Map<String, Integer> getCatchMap() {
        return catchMap;
    }

    public int getMinBreedingFoodlevel() {
        return minBreedingFoodlevel;
    }
    public int getMaxTilesPerTurn() {
        return maxTilesPerTurn;
    }
    public boolean isNewBorn() {
        return newBorn;
    }

    public void setHasMate(boolean hasMate) {
        this.hasMate = hasMate;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setRequiredFoodWeight(double requiredFoodWeight) {
        this.requiredFoodWeight = requiredFoodWeight;
    }

    public void setCatchMap(Map<String, Integer> catchMap) {
        this.catchMap = catchMap;
    }

    public void setMinBreedingFoodlevel(int minBreedingFoodlevel) {
        this.minBreedingFoodlevel = minBreedingFoodlevel;
    }

    public void setMaxTilesPerTurn(int maxTilesPerTurn) {
        this.maxTilesPerTurn = maxTilesPerTurn;
    }

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
                i--;
            }
        }
    }

    private List<Organism> localiseAvailableFood() {
        List<Organism> allOrganismList = getIslandSimulator().retrieveAllTileOrganisms(getXCoordinate(), getYCoordinate());
        Collections.shuffle(allOrganismList, ThreadLocalRandom.current());
        List<Organism> availableFood = allOrganismList.stream()
                .filter(organism -> getCatchMap().containsKey(organism.getClass().getSimpleName()))
                .collect(Collectors.toCollection(ArrayList::new));
        return availableFood;
    }

    public void collectFood() {
        for (Organism organism : localiseAvailableFood()) {
            if (fedLevel >= 100) {
                return;
            }
            synchronized (organism) {
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
        } else {
            return false;
        }
    }

    protected void reduceFedLevel() {
        fedLevel -= 20;
    }

    private Set<Animal> localisePotentialMates() {
        Set<Organism> set = getIslandSimulator().retrieveSpecificOrganisms(this.getClass(), getXCoordinate(), getYCoordinate());
        set.remove(this);
        return set.stream()
                .map(organism -> (Animal) organism)
                .filter(animal -> !animal.isNewBorn())
                .filter(animal -> animal.isAlive())
                .filter(animal -> !animal.isHasMate())
                .collect(Collectors.toCollection(HashSet::new));
    }

    protected Animal chooseMate() {
        for (Animal animal : localisePotentialMates()) {
            synchronized (Animal.class) {
                if(!animal.isHasMate()) {
                    hasMate = true;
                    animal.setHasMate(true);
                    return animal;
                }
            }
        }
        return null;
    }
    public boolean breed() {
        if (getFedLevel() <= getMinBreedingFoodlevel()) {
            return false;
        }
        if (isHasMate()) {
            return true;
        }
        else {
            Animal mate = chooseMate();
            if (mate != null && mate.isAlive()) {
                Animal animal = organismFactory.createAnimal(this.getClass(),(int) getFedLevel()-getMinBreedingFoodlevel());
                boolean successfull = animal.setInitialPosition(getIslandSimulator(), getXCoordinate(), getYCoordinate());
                return successfull;
            }
            else {
                return false;
            }
        }
    }

    public void run() {
        try {
            synchronized (this) {
                if (isAlive()) {
                    move(getMaxTilesPerTurn());
                    collectFood();
                    reduceFedLevel();
                    if (fedLevel <= 0) {
                        this.die();
                    }
                    breed();
                }
            }
        } catch (Exception e) {
            System.out.println(String.format("ERROR: Something went wrong with Animal: %s", this));
            System.out.println(e);
        }
    }

    public void updateForNextTurn() {
        hasMate = false;
        newBorn = false;
    }

}
