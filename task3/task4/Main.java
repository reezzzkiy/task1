package task4;

import task4.model.*;
import task4.service.BookService;
import task4.service.OrderService;
import task4.service.RequestService;
import task4.service.impl.BookServiceImpl;
import task4.service.impl.OrderServiceImpl;
import task4.service.impl.RequestServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RequestService requestService = new RequestServiceImpl();
        BookService bookService = new BookServiceImpl(requestService);
        OrderService orderService = new OrderServiceImpl(bookService, requestService);


        bookService.addBook(new Book(1, "Java OOP", "Ivan Petrov", 29.99, BookStatus.AVAILABLE, LocalDate.now().minusMonths(8), "Книга по ООП на Java"));
        bookService.addBook(new Book(2, "Clean Code", "Robert Martin", 39.5, BookStatus.UNAVAILABLE, LocalDate.now().minusMonths(2), "Практики чистого кода"));
        bookService.addBook(new Book(3, "Algorithms", "CLRS", 49.0, BookStatus.AVAILABLE, LocalDate.now().minusMonths(10), "Algorithms description"));


        System.out.println("\n--- Список книг по алфавиту ---");
        bookService.getBooksSortedByTitle().forEach(System.out::println);


        System.out.println("\n--- Залежавшиеся книги (>6 месяцев) ---");
        bookService.getStaleBooks().forEach(System.out::println);

        System.out.println("\n--- Залежавшиеся книги (сортировка по дате поступления) ---");
        bookService.getStaleBooksSortedByArrivalDate().forEach(System.out::println);

        System.out.println("\n--- Залежавшиеся книги (сортировка по цене) ---");
        bookService.getStaleBooksSortedByPrice().forEach(System.out::println);


        Customer alice = new Customer(1, "Alice", "alice@example.com");
        Customer bob = new Customer(2, "Bob", "bob@example.com");


        System.out.println("\n--- Создаём заказы ---");
        orderService.createOrder(1, alice); 
        orderService.createOrder(2, bob);   


        System.out.println("\n--- Пытаемся завершить заказ 2 (должно отказать) ---");
        orderService.completeOrder(2);


        System.out.println("\n--- Добавляем книгу 2 на склад (статус AVAILABLE) ---");
        bookService.addBook(new Book(2, "Clean Code", "Robert Martin", 39.5, BookStatus.AVAILABLE, LocalDate.now(), "Практики чистого кода"));

        System.out.println("\n--- Теперь можно завершить заказ 2 ---");
        orderService.completeOrder(2);


        System.out.println("\n--- Отчёт: выполненные за период ---");
        LocalDate from = LocalDate.now().minusDays(1);
        LocalDate to = LocalDate.now().plusDays(1);
        List<Order> completed = orderService.getCompletedOrders(from, to);
        completed.forEach(System.out::println);

        System.out.println("Доход за период: " + orderService.getRevenue(from, to));
        System.out.println("Количество выполненных: " + orderService.getCompletedOrdersCount(from, to));

        System.out.println("\n--- Детали заказа 1 ---");
        orderService.getOrderById(1).ifPresent(o -> {
            System.out.println("Заказ: " + o);
            System.out.println("Книга описание: " + o.getBook().getDescription());
            System.out.println("Покупатель: " + o.getCustomer());
        });
    }
}
