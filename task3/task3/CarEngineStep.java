package task3;

public class CarEngineStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        System.out.println("Изготавливается двигатель...");
        return new CarPart("Двигатель");
    }
}