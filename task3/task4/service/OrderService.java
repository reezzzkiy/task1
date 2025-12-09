package task4.service;

import task4.model.Order;
import task4.model.Customer;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    enum SortType {
        DATE,
        PRICE,
        STATUS,
        NONE
    }

    void createOrder(int bookId, Customer customer);

    void completeOrder(int orderId);

    void cancelOrder(int orderId);

    Optional<Order> getOrderById(int id);

    List<Order> getAllOrders();

    List<Order> getOrders(SortType sortType);

    List<Order> getCompletedOrders(LocalDate from, LocalDate to);

    double getRevenue(LocalDate from, LocalDate to);

    int getCompletedOrdersCount(LocalDate from, LocalDate to);

}