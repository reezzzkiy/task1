package task3;

public class Main {
    public static void main(String[] args) {
        ILineStep bodyStep = new CarBodyStep();
        ILineStep chassisStep = new CarChassisStep();
        ILineStep engineStep = new CarEngineStep();

        IAssemblyLine assemblyLine = new CarAssemblyLine(bodyStep, chassisStep, engineStep);

        IProduct car = new Car();
        assemblyLine.assembleProduct(car);

        System.out.println();
        System.out.println(car);
    }
}