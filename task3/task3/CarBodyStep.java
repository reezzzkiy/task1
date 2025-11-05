public class CarBodyStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        System.out.println("Изготавливается автомобильный кузов...");
        return new ProductPart("Автомобильный кузов");
    }
}
