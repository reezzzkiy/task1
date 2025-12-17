package task4.service.impl;

import task4.model.*;
import task4.enumerate.OrderSortType;
import task4.service.BookService;
import task4.service.OrderService;
import task4.service.RequestService;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    private final Map<Integer, Order> orders = new HashMap<>();
    private final BookService bookService;
    private final RequestService requestService;
    private final AtomicInteger idGen = new AtomicInteger(1);

    public OrderServiceImpl(BookService bookService, RequestService requestService) {
        this.bookService = bookService;
        this.requestService = requestService;
    }

    @Override
    public void createOrder(int bookId, Customer customer) {
        Optional<Book> maybeBook = bookService.getBookById(bookId);
        if (maybeBook.isEmpty()) {
            System.out.println("Книга не найдена.");
            return;
        }

        Book book = maybeBook.get();
        Order order = new Order(idGen.getAndIncrement(), book, customer, LocalDate.now());
        orders.put(order.getId(), order);

        if (book.getStatus() == BookStatus.AVAILABLE) {
            book.setStatus(BookStatus.UNAVAILABLE);
            bookService.updateBook(book);
            System.out.println("Создан заказ: " + order);
        } else {
            requestService.createRequest(bookId);
            System.out.println("Книга недоступна. Создан запрос и заказ: " + order);
        }
    }

    @Override
    public void completeOrder(int orderId) {
        Order order = orders.get(orderId);
        if (order == null) {
            System.out.println("Заказ не найден");
            return;
        }
        if (requestService.hasOpenRequest(order.getBook().getId())) {
            System.out.println("Нельзя завершить — есть открытый запрос!");
            return;
        }
        order.setStatus(OrderStatus.COMPLETE);
        order.setCompleteDate(LocalDate.now());
        System.out.println("Заказ завершён: " + order);
    }

    @Override
    public void cancelOrder(int orderId) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setStatus(OrderStatus.CANCELLED);
            System.out.println("Заказ отменён: " + order);

            Book book = order.getBook();
            book.setStatus(BookStatus.AVAILABLE);
            bookService.updateBook(book);
        }
    }

    @Override
    public Optional<Order> getOrderById(int id) {
        return Optional.ofNullable(orders.get(id));
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public List<Order> getOrders(OrderSortType sortType) {
        Comparator<Order> comparator = switch (sortType) {
            case DATE -> Comparator.comparing(Order::getOrderDate);
            case PRICE -> Comparator.comparingDouble(Order::getTotalPrice);
            case STATUS -> Comparator.comparing(Order::getStatus);
            case NONE -> null;
        };

        return orders.values().stream()
                .sorted(comparator != null ? comparator : (a, b) -> 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getCompletedOrders(LocalDate from, LocalDate to) {
        return orders.values().stream()
                .filter(o -> o.getStatus() == OrderStatus.COMPLETE)
                .filter(o -> {
                    LocalDate d = o.getCompleteDate();
                    return d != null && (!d.isBefore(from) && !d.isAfter(to));
                })
                .collect(Collectors.toList());
    }

    @Override
    public double getRevenue(LocalDate from, LocalDate to) {
        return getCompletedOrders(from, to).stream()
                .mapToDouble(Order::getTotalPrice)
                .sum();
    }

    @Override
    public int getCompletedOrdersCount(LocalDate from, LocalDate to) {
        return getCompletedOrders(from, to).size();
    }
}
