package task3;

public class Car implements IProduct {
    private IProductPart body;
    private IProductPart chassis;
    private IProductPart engine;

    @Override
    public void installFirstPart(IProductPart part) {
        body = part;
        System.out.println("Установлен кузов: " + ((CarPart) part).getName());
    }

    @Override
    public void installSecondPart(IProductPart part) {
        chassis = part;
        System.out.println("Установлено шасси: " + ((CarPart) part).getName());
    }

    @Override
    public void installThirdPart(IProductPart part) {
        engine = part;
        System.out.println("Установлен двигатель: " + ((CarPart) part).getName());
    }

    @Override
    public String toString() {
        return "Автомобиль собран: " +
                ((CarPart) body).getName() + ", " +
                ((CarPart) chassis).getName() + ", " +
                ((CarPart) engine).getName();
    }
}
