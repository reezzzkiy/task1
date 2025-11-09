package task4.service;


public interface OrderService {
    void createOrder(int bookId);
    void completeOrder(int orderId);
    void cancelOrder(int orderId);
}