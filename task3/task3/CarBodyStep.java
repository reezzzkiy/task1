package task3;

public class CarBodyStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        System.out.println("Изготавливается кузов...");
        return new CarPart("Кузов");
    }
}
