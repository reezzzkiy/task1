package task4;

public class Order {
    private Book book;
    private String status;

    public Order(Book book) {
        this.book = book;
        this.status = "новый";
        System.out.println("Создан заказ на книгу: " + book.getTitle());
    }

    public Book getBook() {
        return book;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        System.out.println("Статус заказа на \"" + book.getTitle() + "\" изменен на: " + status);
    }

    @Override
    public String toString() {
        return "Заказ: " + book.getTitle() + " [" + status + "]";
    }
}
