public class Car implements IProduct {
    private IProductPart body;
    private IProductPart chassis;
    private IProductPart engine;

    @Override
    public void installFirstPart(IProductPart part) {
        body = part;
        System.out.println("Установлен кузов: " + part.getName());
    }

    @Override
    public void installSecondPart(IProductPart part) {
        chassis = part;
        System.out.println("Установлено шасси: " + part.getName());
    }

    @Override
    public void installThirdPart(IProductPart part) {
        engine = part;
        System.out.println("Установлен двигатель: " + part.getName());
    }

    @Override
    public String toString() {
        return "Car { body=" + body + ", chassis=" + chassis + ", engine=" + engine + " }";
    }
}
