package task4.service;

import task4.DataStorage;
import task4.model.*;

public class OrderServiceImpl implements OrderService {

    private final BookService bookService;
    private final RequestService requestService;

    private int orderCounter = 1;

    public OrderServiceImpl(BookService bookService, RequestService requestService) {
        this.bookService = bookService;
        this.requestService = requestService;
    }

    @Override
    public void createOrder(int bookId) {
        Book book = bookService.getBookById(bookId);

        if (book == null) {
            System.out.println("Книга не найдена.");
            return;
        }

        Order order = new Order(orderCounter++, book);
        DataStorage.orders.put(order.getId(), order);

        if (book.getStatus() == BookStatus.AVAILABLE) {
            book.setStatus(BookStatus.UNAVAILABLE);
            bookService.updateBook(book);
            System.out.println("Создан заказ: " + order);
        } else {
            requestService.createRequest(bookId);
            System.out.println("Книга недоступна. Создан Request и заказ: " + order);
        }
    }

    @Override
    public void completeOrder(int orderId) {
        Order order = DataStorage.orders.get(orderId);

        if (order == null) {
            System.out.println("Заказ не найден");
            return;
        }

        if (requestService.hasOpenRequest(order.getBook().getId())) {
            System.out.println("Нельзя завершить — есть открытый запрос!");
            return;
        }

        order.setStatus(OrderStatus.COMPLETE);
        System.out.println("Заказ завершён: " + order);
    }

    @Override
    public void cancelOrder(int orderId) {
        Order order = DataStorage.orders.get(orderId);
        if (order != null) {
            order.setStatus(OrderStatus.CANCELLED);
            System.out.println("Заказ отменён: " + order);
        }
    }
}