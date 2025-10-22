package task4;

import java.util.ArrayList;
import java.util.List;

public class BookStore {
    private List<Book> books = new ArrayList<>();
    private List<Request> requests = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Добавлена книга: " + book);
    }

    public Order createOrder(String title) {
        Book book = findBook(title);
        if (book == null) {
            System.out.println("Ошибка: книги \"" + title + "\" нет в каталоге!");
            return null;
        }

        if (!book.isAvailable()) {
            System.out.println("Книга \"" + title + "\" отсутствует — создается запрос.");
            requests.add(new Request(book));
        }

        Order order = new Order(book);
        orders.add(order);
        return order;
    }

    public void cancelOrder(Order order) {
        order.setStatus("отменен");
    }

    public void completeOrder(Order order) {
        if (order.getBook().isAvailable()) {
            order.setStatus("выполнен");
        } else {
            System.out.println("Нельзя выполнить заказ — книга \"" + order.getBook().getTitle() + "\" отсутствует.");
        }
    }

    public void addBookToStock(String title) {
        Book book = findBook(title);
        if (book == null) {
            System.out.println("Ошибка: книги \"" + title + "\" нет в каталоге!");
            return;
        }

        book.setAvailable(true);
        requests.removeIf(r -> r.getBook() == book);
        System.out.println("Все запросы на \"" + title + "\" закрыты.");
    }

    public void removeBookFromStock(String title) {
        Book book = findBook(title);
        if (book != null) {
            book.setAvailable(false);
        }
    }

    private Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void showStatus() {
        System.out.println("\n=== Текущий статус магазина ===");
        System.out.println("Книги:");
        for (Book b : books) System.out.println("  " + b);
        System.out.println("Заказы:");
        for (Order o : orders) System.out.println("  " + o);
        System.out.println("Запросы:");
        for (Request r : requests) System.out.println("  " + r.getBook().getTitle());
        System.out.println("==============================\n");
    }
}
