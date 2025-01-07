import java.util.ArrayList;
import java.util.List;

public class OrganismFactory {

    public Plant createPlant() {
        return new Plant();
    }
    public Wolf createWolf(double fedLevel) {
        return new Wolf(fedLevel);
    }
    public Sheep createSheep(double fedLevel) {
        return new Sheep(fedLevel);
    }


}
