import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Tile {
    private Map<Class<? extends Organism>, Set<Organism>> organismMap = new ConcurrentHashMap<>();
    private static final Map<String, Integer> maxCapacityMap = new ConcurrentHashMap<>() {
        {
            this.put("Plant", 200);
            this.put("Wolf", 5);
            this.put("Sheep", 140);
        }
    };

    public Tile() {
    }
    
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

    private Set<Class<? extends Organism>> keySet() {
        return organismMap.keySet();
    }
    private Set<Organism> getOrganismSet(Class<? extends Organism> clazz) {
        return organismMap.get(clazz);
    }

    private void addOrganismClass(Class<? extends Organism> clazz) {
        organismMap.put(clazz, ConcurrentHashMap.newKeySet());
    }

    public synchronized boolean addOrganism(Organism organism) {
        if (isFull(organism)) {
            return false;
        }
        else if (contains(organism.getClass())) {
            getOrganismSet(organism.getClass()).add(organism);
            return true;
        }
        else {
            addOrganismClass(organism.getClass());
            getOrganismSet(organism.getClass()).add(organism);
            return true;
        }
    }
    public void removeOrganism(Organism organism) {
        getOrganismSet(organism.getClass()).remove(organism);
    }

    public List<Organism> retrieveAllOrganisms() {
        List<Organism> organismList = new ArrayList<>();
        for (Class<? extends Organism> clazz : keySet()) {
            organismList.addAll(getOrganismSet(clazz));
        }
        return organismList;
    }

    public boolean contains(Class<? extends Organism> clazz) {
        return organismMap.containsKey(clazz);
    }
}
