package task4.model;

public class Order {
    private final int id;
    private final Book book;
    private OrderStatus status;

    public Order(int id, Book book) {
        this.id = id;
        this.book = book;
        this.status = OrderStatus.NEW;
    }

    public int getId() { return id; }
    public Book getBook() { return book; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    @Override
    public String toString() {
        return "Order #" + id + " [book=" + book.getTitle() + ", status=" + status + "]";
    }
}