package task3;

public class CarChassisStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        System.out.println("Изготавливается шасси...");
        return new CarPart("Шасси");
    }
}