package task3;

public class CarAssemblyLine implements IAssemblyLine {
    private ILineStep step1;
    private ILineStep step2;
    private ILineStep step3;

    public CarAssemblyLine(ILineStep step1, ILineStep step2, ILineStep step3) {
        this.step1 = step1;
        this.step2 = step2;
        this.step3 = step3;
    }

    @Override
    public IProduct assembleProduct(IProduct product) {
        System.out.println("=== Начало сборки автомобиля ===");
        product.installFirstPart(step1.buildProductPart());
        product.installSecondPart(step2.buildProductPart());
        product.installThirdPart(step3.buildProductPart());
        System.out.println("=== Сборка автомобиля завершена ===");
        return product;
    }
}