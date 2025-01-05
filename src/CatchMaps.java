import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CatchMaps {

    public static final Map<String, Integer> WOLFCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Wolf", -1);
            this.put("Boa", 0);
            this.put("Fox", 0);
            this.put("Bear", 0);
            this.put("Eagle", 0);
            this.put("Horse", 10);
            this.put("Deer", 15);
            this.put("Rabbit", 60);
            this.put("Mouse", 80);
            this.put("Goat", 60);
            this.put("Sheep", 70);
            this.put("Boar", 15);
            this.put("Buffalo", 10);
            this.put("Duck", 40);
            this.put("Caterpillar", 0);
            this.put("Plant", 0);
        }
    };

    public static final Map<String, Integer> BOACATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Wolf", 0);
            this.put("Boa", -1);
            this.put("Fox", 15);
            this.put("Bear", 0);
            this.put("Eagle", 0);
            this.put("Horse", 0);
            this.put("Deer", 0);
            this.put("Rabbit", 20);
            this.put("Mouse", 40);
            this.put("Goat", 0);
            this.put("Sheep", 0);
            this.put("Boar", 0);
            this.put("Buffalo", 0);
            this.put("Duck", 10);
            this.put("Caterpillar", 0);
            this.put("Plant", 0);
        }
    };

    public static final Map<String, Integer> FOXCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Wolf", 0);
            this.put("Boa", 0);
            this.put("Fox", -1);
            this.put("Bear", 0);
            this.put("Eagle", 0);
            this.put("Horse", 0);
            this.put("Deer", 0);
            this.put("Rabbit", 70);
            this.put("Mouse", 90);
            this.put("Goat", 0);
            this.put("Sheep", 0);
            this.put("Boar", 0);
            this.put("Buffalo", 0);
            this.put("Duck", 60);
            this.put("Caterpillar", 40);
            this.put("Plant", 0);
        }
    };


    public static final Map<String, Integer> BEARCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Wolf", 0);
            this.put("Boa", 80);
            this.put("Fox", 0);
            this.put("Bear", -1);
            this.put("Eagle", 0);
            this.put("Horse", 40);
            this.put("Deer", 80);
            this.put("Rabbit", 80);
            this.put("Mouse", 90);
            this.put("Goat", 70);
            this.put("Sheep", 70);
            this.put("Boar", 50);
            this.put("Buffalo", 20);
            this.put("Duck", 10);
            this.put("Caterpillar", 0);
            this.put("Plant", 0);
        }
    };

    public static final Map<String, Integer> EAGLECATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Wolf", 0);
            this.put("Boa", 0);
            this.put("Fox", 10);
            this.put("Bear", 0);
            this.put("Eagle", -1);
            this.put("Horse", 0);
            this.put("Deer", 0);
            this.put("Rabbit", 90);
            this.put("Mouse", 90);
            this.put("Goat", 0);
            this.put("Sheep", 0);
            this.put("Boar", 0);
            this.put("Buffalo", 0);
            this.put("Duck", 80);
            this.put("Caterpillar", 0);
            this.put("Plant", 0);
        }
    };

    public static final Map<String, Integer> HORSECATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Wolf", 0);
            this.put("Boa", 0);
            this.put("Fox", 0);
            this.put("Bear", 0);
            this.put("Eagle", 0);
            this.put("Horse", -1);
            this.put("Deer", 0);
            this.put("Rabbit", 0);
            this.put("Mouse", 0);
            this.put("Goat", 0);
            this.put("Sheep", 0);
            this.put("Boar", 0);
            this.put("Buffalo", 0);
            this.put("Duck", 0);
            this.put("Caterpillar", 0);
            this.put("Plant", 100);
        }
    };

    public static final Map<String, Integer> DEERCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Wolf", 0);
            this.put("Boa", 0);
            this.put("Fox", 0);
            this.put("Bear", 0);
            this.put("Eagle", 0);
            this.put("Horse", 0);
            this.put("Deer", -1);
            this.put("Rabbit", 0);
            this.put("Mouse", 0);
            this.put("Goat", 0);
            this.put("Sheep", 0);
            this.put("Boar", 0);
            this.put("Buffalo", 0);
            this.put("Duck", 0);
            this.put("Caterpillar", 0);
            this.put("Plant", 100);
        }
    };

    public static final Map<String, Integer> RABBITCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Wolf", 0);
            this.put("Boa", 0);
            this.put("Fox", 0);
            this.put("Bear", 0);
            this.put("Eagle", 0);
            this.put("Horse", 0);
            this.put("Deer", 0);
            this.put("Rabbit", -1);
            this.put("Mouse", 0);
            this.put("Goat", 0);
            this.put("Sheep", 0);
            this.put("Boar", 0);
            this.put("Buffalo", 0);
            this.put("Duck", 0);
            this.put("Caterpillar", 0);
            this.put("Plant", 100);
        }
    };

    public static final Map<String, Integer> MOUSECATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Wolf", 0);
            this.put("Boa", 0);
            this.put("Fox", 0);
            this.put("Bear", 0);
            this.put("Eagle", 0);
            this.put("Horse", 0);
            this.put("Deer", 0);
            this.put("Rabbit", 0);
            this.put("Mouse", 0);
            this.put("Goat", 0);
            this.put("Sheep", 0);
            this.put("Boar", 0);
            this.put("Buffalo", 0);
            this.put("Duck", 0);
            this.put("Caterpillar", 90);
            this.put("Plant", 100);
        }
    };

    public static final Map<String, Integer> GOATCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Wolf", 0);
            this.put("Boa", 0);
            this.put("Fox", 0);
            this.put("Bear", 0);
            this.put("Eagle", 0);
            this.put("Horse", 0);
            this.put("Deer", 0);
            this.put("Rabbit", 0);
            this.put("Mouse", 0);
            this.put("Goat", -1);
            this.put("Sheep", 0);
            this.put("Boar", 0);
            this.put("Buffalo", 0);
            this.put("Duck", 0);
            this.put("Caterpillar", 0);
            this.put("Plant", 100);
        }
    };

    public static final Map<String, Integer> SHEEPCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Wolf", 0);
            this.put("Boa", 0);
            this.put("Fox", 0);
            this.put("Bear", 0);
            this.put("Eagle", 0);
            this.put("Horse", 0);
            this.put("Deer", 0);
            this.put("Rabbit", 0);
            this.put("Mouse", 0);
            this.put("Goat", 0);
            this.put("Sheep", -1);
            this.put("Boar", 0);
            this.put("Buffalo", 0);
            this.put("Duck", 0);
            this.put("Caterpillar", 0);
            this.put("Plant", 100);
        }
    };

    public static final Map<String, Integer> BOARCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Wolf", 0);
            this.put("Boa", 0);
            this.put("Fox", 0);
            this.put("Bear", 0);
            this.put("Eagle", 0);
            this.put("Horse", 0);
            this.put("Deer", 0);
            this.put("Rabbit", 0);
            this.put("Mouse", 0);
            this.put("Goat", 0);
            this.put("Sheep", 0);
            this.put("Boar", -1);
            this.put("Buffalo", 0);
            this.put("Duck", 0);
            this.put("Caterpillar", 90);
            this.put("Plant", 100);
        }
    };

    public static final Map<String, Integer> BUFFALOCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Wolf", 0);
            this.put("Boa", 0);
            this.put("Fox", 0);
            this.put("Bear", 0);
            this.put("Eagle", 0);
            this.put("Horse", 0);
            this.put("Deer", 0);
            this.put("Rabbit", 0);
            this.put("Mouse", 0);
            this.put("Goat", 0);
            this.put("Sheep", 0);
            this.put("Boar", 0);
            this.put("Buffalo", -1);
            this.put("Duck", 0);
            this.put("Caterpillar", 0);
            this.put("Plant", 100);
        }
    };

    public static final Map<String, Integer> DUCKCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Wolf", 0);
            this.put("Boa", 0);
            this.put("Fox", 0);
            this.put("Bear", 0);
            this.put("Eagle", 0);
            this.put("Horse", 0);
            this.put("Deer", 0);
            this.put("Rabbit", 0);
            this.put("Mouse", 0);
            this.put("Goat", 0);
            this.put("Sheep", 0);
            this.put("Boar", 0);
            this.put("Buffalo", 0);
            this.put("Duck", -1);
            this.put("Caterpillar", 90);
            this.put("Plant", 100);
        }
    };

    public static final Map<String, Integer> CATERPILLARCATCHMAP = new ConcurrentHashMap<>() {
        {
            this.put("Wolf", 0);
            this.put("Boa", 0);
            this.put("Fox", 0);
            this.put("Bear", 0);
            this.put("Eagle", 0);
            this.put("Horse", 0);
            this.put("Deer", 0);
            this.put("Rabbit", 0);
            this.put("Mouse", 0);
            this.put("Goat", 0);
            this.put("Sheep", 0);
            this.put("Boar", 0);
            this.put("Buffalo", 0);
            this.put("Duck", 0);
            this.put("Caterpillar", -1);
            this.put("Plant", 100);
        }
    };
}
