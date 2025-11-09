public class CarChassisStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        System.out.println("Изготавливается шасси для автомобиля...");
        return new ProductPart("Шасси автомобиля");
    }
}
