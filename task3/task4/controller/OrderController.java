package task4.controller;

import task4.model.Customer;
import task4.service.OrderService;

import java.util.Scanner;

public class OrderController {

    private final OrderService orderService;
    private final Scanner scanner;

    public OrderController(OrderService orderService, Scanner scanner) {
        this.orderService = orderService;
        this.scanner = scanner;
    }

    public void listAll() {
        orderService.getAllOrders().forEach(System.out::println);
    }

    public void createOrder() {
        try {
            System.out.print("bookId: ");
            int bookId = Integer.parseInt(scanner.nextLine());

            System.out.print("customerId: ");
            int customerId = Integer.parseInt(scanner.nextLine());

            System.out.print("customerName: ");
            String name = scanner.nextLine();

            System.out.print("customerEmail: ");
            String email = scanner.nextLine();

            Customer customer = new Customer(customerId, name, email);
            orderService.createOrder(bookId, customer);

        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    public void completeOrder() {
        try {
            System.out.print("orderId: ");
            int orderId = Integer.parseInt(scanner.nextLine());
            orderService.completeOrder(orderId);
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    public void cancelOrder() {
        try {
            System.out.print("orderId: ");
            int orderId = Integer.parseInt(scanner.nextLine());
            orderService.cancelOrder(orderId);
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
}
