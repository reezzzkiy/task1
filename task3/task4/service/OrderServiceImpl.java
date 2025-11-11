package task4.service;

import task4.model.*;
import java.util.HashMap;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private final Map<Integer, Order> orders = new HashMap<>();
    private int orderCounter = 1;

    private final RequestService requestService;

    public OrderServiceImpl(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public Order createOrder(Book book) {
        Order order = new Order(orderCounter++, book);

        if (book.getStatus() == BookStatus.UNAVAILABLE) {
            System.out.println("Книги \"" + book.getTitle() + "\" нет в наличии — создаётся запрос.");
            requestService.createRequest(book);
        } else {
            System.out.println("Создан заказ на книгу \"" + book.getTitle() + "\".");
        }

        orders.put(order.getId(), order);
        return order;
    }

    @Override
    public void cancelOrder(int orderId) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setStatus(OrderStatus.CANCELED);
            System.out.println("Заказ #" + orderId + " отменён.");
        }
    }

    @Override
    public void completeOrder(int orderId) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setStatus(OrderStatus.COMPLETED);
            System.out.println("Заказ #" + orderId + " выполнен.");
        }
    }
}
