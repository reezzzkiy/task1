package task4;

import task4.model.*;
import task4.service.*;
import task4.DataStorage;

public class Main {
    public static void main(String[] args) {

        RequestService requestService = new RequestServiceImpl();
        BookService bookService = new BookServiceImpl(requestService);
        OrderService orderService = new OrderServiceImpl(bookService, requestService);

        // Создаем книги
        bookService.addBook(new Book(1, "Java OOP", BookStatus.AVAILABLE));
        bookService.addBook(new Book(2, "Clean Code", BookStatus.UNAVAILABLE));

        System.out.println("\n--- Создаём заказы ---");

        // Заказ на доступную книгу
        orderService.createOrder(1);

        // Заказ на недоступную книгу → создаёт запрос
        orderService.createOrder(2);

        System.out.println("\n--- Пытаемся завершить заказ 2 (должно отказать) ---");
        orderService.completeOrder(2);

        System.out.println("\n--- Добавляем книгу 2 — реквесты закроются ---");
        bookService.addBook(new Book(2, "Clean Code", BookStatus.AVAILABLE));

        System.out.println("\n--- Теперь можно завершить заказ 2 ---");
        orderService.completeOrder(2);
    }
}
