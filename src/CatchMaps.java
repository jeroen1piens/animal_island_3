import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CatchMaps {

    public static final Map<String, Integer> WOLFCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Horse", 10);
            this.put("Deer", 15);
            this.put("Rabbit", 60);
            this.put("Mouse", 80);
            this.put("Goat", 60);
            this.put("Sheep", 70);
            this.put("Boar", 15);
            this.put("Buffalo", 10);
            this.put("Duck", 40);
        }
    };

    public static final Map<String, Integer> BOACATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Fox", 15);
            this.put("Rabbit", 20);
            this.put("Mouse", 40);
            this.put("Duck", 10);
        }
    };

    public static final Map<String, Integer> FOXCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Rabbit", 70);
            this.put("Mouse", 90);
            this.put("Duck", 60);
            this.put("Caterpillar", 40);
        }
    };


    public static final Map<String, Integer> BEARCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Boa", 80);
            this.put("Horse", 40);
            this.put("Deer", 80);
            this.put("Rabbit", 80);
            this.put("Mouse", 90);
            this.put("Goat", 70);
            this.put("Sheep", 70);
            this.put("Boar", 50);
            this.put("Buffalo", 20);
            this.put("Duck", 10);
        }
    };

    public static final Map<String, Integer> EAGLECATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Fox", 10);
            this.put("Rabbit", 90);
            this.put("Mouse", 90);
            this.put("Duck", 80);
        }
    };

    public static final Map<String, Integer> HORSECATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Plant", 100);
        }
    };

    public static final Map<String, Integer> DEERCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Plant", 100);
        }
    };

    public static final Map<String, Integer> RABBITCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Plant", 100);
        }
    };

    public static final Map<String, Integer> MOUSECATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Caterpillar", 90);
            this.put("Plant", 100);
        }
    };

    public static final Map<String, Integer> GOATCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Plant", 100);
        }
    };

    public static final Map<String, Integer> SHEEPCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Plant", 100);
        }
    };

    public static final Map<String, Integer> BOARCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Caterpillar", 90);
            this.put("Plant", 100);
        }
    };

    public static final Map<String, Integer> BUFFALOCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Plant", 100);
        }
    };

    public static final Map<String, Integer> DUCKCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Caterpillar", 90);
            this.put("Plant", 100);
        }
    };

    public static final Map<String, Integer> CATERPILLARCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Plant", 100);
        }
    };
}
