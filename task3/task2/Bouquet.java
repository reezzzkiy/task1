package task2;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {
    private List<Flower> flowers = new ArrayList<>();

    public void addFlower(Flower flower) {
        flowers.add(flower);
        System.out.println("Добавлен цветок: " + flower);
    }

    public double getTotalPrice() {
        double sum = 0;
        for (Flower flower : flowers) {
            sum += flower.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Букет состоит из:\n");
        for (Flower flower : flowers) {
            sb.append("- ").append(flower).append("\n");
        }
        sb.append("Общая стоимость: ").append(getTotalPrice()).append(" руб.");
        return sb.toString();
    }
}
