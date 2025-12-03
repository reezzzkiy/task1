public class Main {
    public static void main(String[] args) {
        
        ILineStep carStep1 = new CarBodyStep();
        ILineStep carStep2 = new CarChassisStep();
        ILineStep carStep3 = new CarEngineStep();

        IAssemblyLine carLine = new GenericAssemblyLine(carStep1, carStep2, carStep3);
        IProduct car = new Car();
        System.out.println("=== Сборка 1: Автомобиль ===");
        carLine.assembleProduct(car);
        System.out.println(car);

    }
}
