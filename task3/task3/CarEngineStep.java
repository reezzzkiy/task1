public class CarEngineStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        System.out.println("Изготавливается двигатель автомобиля...");
        return new ProductPart("Двигатель автомобиля");
    }
}
