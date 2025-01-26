package simulation;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Tile {
    private volatile Map<Class<? extends Organism>, Set<Organism>> organismMap = new ConcurrentHashMap<>();
    private static final Map<String, Integer> maxCapacityMap = new ConcurrentHashMap<>() {
        {
            this.put("Bear", 5);
            this.put("Boa", 30);
            this.put("Boar", 50);
            this.put("Buffalo", 10);
            this.put("Caterpillar", 1000);
            this.put("Deer", 20);
            this.put("Duck", 150);
            this.put("Eagle", 20);
            this.put("Fox", 30);
            this.put("Goat", 140);
            this.put("Horse", 20);
            this.put("Mouse", 500);
            this.put("Plant", 200);
            this.put("Rabbit", 150);
            this.put("Wolf", 5);
            this.put("Sheep", 140);
        }
    };

    public Tile() {
    }

    //Informs if the tile is full for a certain organism species
    public boolean isFull(Organism organism) {
        if (!organismMap.containsKey(organism.getClass())) {
            return false;
        }
        int occupancy = organismMap.get(organism.getClass()).size();
        int capacity = maxCapacityMap.get(organism.getClass().getSimpleName());
        if (occupancy >= capacity) {
            return true;
        } else {
            return false;
        }
    }

    //Provides a set of all the Organism classes in the organismMap in this tile.
    private Set<Class<? extends Organism>> keySet() {
        return organismMap.keySet();
    }
    public Set<Organism> retrieveSpecificOrganisms(Class<? extends Organism> clazz) {
        Set<Organism> set = new HashSet<>();
        set.addAll(organismMap.get(clazz));
        return set;
    }

    //Helper method to addOrganism.
    private void addOrganismClass(Class<? extends Organism> clazz) {
        organismMap.put(clazz, ConcurrentHashMap.newKeySet());
    }

    //Method adds the organism to the organismMap in this tile.
    public synchronized boolean addOrganism(Organism organism) {
        if (isFull(organism)) {
            return false;
        }
        else if (contains(organism.getClass())) {
            organismMap.get(organism.getClass()).add(organism);
            return true;
        }
        else {
            addOrganismClass(organism.getClass());
            organismMap.get(organism.getClass()).add(organism);
            return true;
        }
    }

    //Removes an organism for the organismMap in this tile
    public void removeOrganism(Organism organism) {
        if (organismMap.get(organism.getClass()).contains(organism)) {
            organismMap.get(organism.getClass()).remove(organism);
        }
        else {
            throw new NoSuchElementException("Organism to be removed not present in the organismMap of the called tile!!!" );
        }
    }

    //Provides a list of all organisms present in this tile
    public List<Organism> retrieveAllOrganisms() {
        List<Organism> organismList = new ArrayList<>();
        for (Class<? extends Organism> clazz : keySet()) {
            organismList.addAll(organismMap.get(clazz));
        }
        return organismList;
    }

    //informs if an organism of a certain class is present in this tile
    public boolean contains(Class<? extends Organism> clazz) {
        return organismMap.containsKey(clazz);
    }

    //informs if an organism of a certain class is present in this tile
    public boolean contains(Organism organism) {
        if (contains(organism.getClass())) {
            return organismMap.get(organism.getClass()).contains(organism);
        }
        else {
            return false;
        }
    }
}
