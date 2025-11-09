package task4;

import task4.model.*;
import task4.service.*;

public class Main {
    public static void main(String[] args) {
        RequestService requestService = new RequestServiceImpl();
        OrderService orderService = new OrderServiceImpl(requestService);
        BookService bookService = new BookServiceImpl();

        Book b1 = new Book(1, "Java. Полное руководство", BookStatus.AVAILABLE);
        Book b2 = new Book(2, "Чистый код", BookStatus.UNAVAILABLE);

        bookService.addBook(b1);
        bookService.addBook(b2);

        orderService.createOrder(b1);
        orderService.createOrder(b2);

        bookService.setBookAvailable(2);
        requestService.closeRequestForBook(b2);

        orderService.completeOrder(1);
    }
}
