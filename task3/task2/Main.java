package task2;

public class Main {
    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(new Rose());
        bouquet.addFlower(new Tulip());
        bouquet.addFlower(new Lily());
        bouquet.addFlower(new Rose());

        System.out.println();
        System.out.println(bouquet);
    }
}
