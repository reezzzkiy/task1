package task4.service;

import task4.model.Book;
import task4.model.Order;

public interface OrderService {
    Order createOrder(Book book);
    void cancelOrder(int orderId);
    void completeOrder(int orderId);
}