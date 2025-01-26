package simulation;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public abstract class Animal extends Organism {
    private double fedLevel = 100;
    private volatile boolean hasMate;
    private double weight;
    private double requiredFoodWeight;
    private Map<String, Integer> catchMap;
    private int minBreedingFoodlevel;
    private int maxTilesPerTurn;

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


    //Helper method for the move method
    private int chooseNextXCoordinate() {
        return ThreadLocalRandom.current().nextInt(getXCoordinate() - 1 >= 0 ? getXCoordinate() - 1 : getXCoordinate(), getXCoordinate() + 1 < getIslandSimulator().getHorizontalLengthIsland() ? getXCoordinate() + 2 : getXCoordinate() + 1);
    }

    //Helper method for the move method
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

    //Helper method for the collectFood method
    private List<Organism> localiseAvailableFood() {
        List<Organism> allOrganismList = getIslandSimulator().retrieveAllTileOrganisms(getXCoordinate(), getYCoordinate());
        Collections.shuffle(allOrganismList, ThreadLocalRandom.current());
        List<Organism> availableFood = allOrganismList.stream()
                .filter(organism -> getCatchMap().containsKey(organism.getClass().getSimpleName()))
                .collect(Collectors.toCollection(ArrayList::new));
        return availableFood;
    }

    //Method by which the animal looks for food on the tile it currently resides
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

    //Helper method for the collectFood method
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

    //Helper method to the chooseMate method
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

    //Helper method to the breed method
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

    //Method by which the animal can procreate
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

    //Method that can be used by a simulator to schedule an Animal as an individual thread
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

    //Method can be used by a simulator to reset certain parameters for the next turn
    @Override
    public void prepareForNextTurn() {
        hasMate = false;
        newBorn = false;
    }

}
