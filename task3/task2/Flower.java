package task2;

public abstract class Flower {
    private String name;
    private double price;

    public Flower(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + price + " руб.)";
    }
}