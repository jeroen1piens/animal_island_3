import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Tile {
    private Map<Class<? extends Organism>, Set<Organism>> organismMap = new ConcurrentHashMap<>();
    private static final Map<String, Integer> maxCapacityMap = new ConcurrentHashMap<>() {
        {
            this.put("Plant", 100);
            this.put("Wolf", 5);
            this.put("Sheep", 140);
        }
    };

    public Tile() {
    }

    public Map<Class<? extends Organism>, Set<Organism>> getOrganismMap() {
        return organismMap;
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
}
