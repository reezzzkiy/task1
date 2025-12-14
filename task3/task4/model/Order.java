package task4.model;

import java.time.LocalDate;

public class Order {

    private int id;
    private Book book;
    private Customer customer;
    private OrderStatus status;
    private LocalDate orderDate;
    private LocalDate completeDate;
    private double totalPrice;

    public Order(int id, Book book, Customer customer, LocalDate orderDate) {
        this.id = id;
        this.book = book;
        this.customer = customer;
        this.status = OrderStatus.NEW;
        this.orderDate = orderDate;
        this.totalPrice = book.getPrice();
    }


    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getCompleteDate() {
        return completeDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setCompleteDate(LocalDate completeDate) {
        this.completeDate = completeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", book=" + book.getTitle() +
                ", customer=" + customer +
                ", status=" + status +
                ", orderDate=" + orderDate +
                '}';
    }

}