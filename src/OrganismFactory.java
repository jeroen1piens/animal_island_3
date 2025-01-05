import java.util.ArrayList;
import java.util.List;

public class OrganismFactory {

    public Plant createPlant() {
        return new Plant();
    }
    public Wolf createWolf() {
        return new Wolf();
    }
    public Sheep createSheep() {
        return new Sheep();
    }
}
