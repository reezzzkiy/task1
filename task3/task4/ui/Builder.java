package task4.ui;

import task4.enumerate.BookSortType;
import task4.model.Book;
import task4.model.Customer;
import task4.service.BookService;
import task4.service.OrderService;
import task4.service.RequestService;

import java.time.LocalDate;
import java.util.Scanner;

public class Builder {
    private final Menu rootMenu = new Menu("Main Menu");
    private final BookService bookService;
    private final OrderService orderService;
    private final RequestService requestService;
    private final Scanner scanner;

    public Builder(BookService bookService, OrderService orderService, RequestService requestService, Scanner scanner) {
        this.bookService = bookService;
        this.orderService = orderService;
        this.requestService = requestService;
        this.scanner = scanner;
    }

    public void buildMenu() {
        Menu books = new Menu("Books");
        books.addItem(
                new MenuItem("List all books", () -> bookService.getAllBooks().forEach(System.out::println), null));
        books.addItem(new MenuItem("Add book", this::actionAddBook, null));
        books.addItem(new MenuItem("List stale books (>6m)",
                () -> bookService.getStaleBooks().forEach(System.out::println), null));
        books.addItem(new MenuItem("Back", null, null));

        Menu orders = new Menu("Orders");
        orders.addItem(
                new MenuItem("List all orders", () -> orderService.getAllOrders().forEach(System.out::println), null));
        orders.addItem(new MenuItem("Create order", this::actionCreateOrder, null));
        orders.addItem(new MenuItem("Complete order", this::actionCompleteOrder, null));
        orders.addItem(new MenuItem("Cancel order", this::actionCancelOrder, null));
        orders.addItem(new MenuItem("Back", null, null));

        Menu requests = new Menu("Requests");
        requests.addItem(new MenuItem("List all requests",
                () -> requestService.getAllRequests().forEach(System.out::println), null));
        requests.addItem(new MenuItem("Create request", this::actionCreateRequest, null));
        requests.addItem(new MenuItem("Back", null, null));

        rootMenu.addItem(new MenuItem("Books", null, books));
        rootMenu.addItem(new MenuItem("Orders", null, orders));
        rootMenu.addItem(new MenuItem("Requests", null, requests));
        rootMenu.addItem(new MenuItem("Exit", () -> System.out.println("Bye"), null));
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

    private void actionAddBook() {
        try {
            System.out.print("id: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("title: ");
            String title = scanner.nextLine();
            System.out.print("author: ");
            String author = scanner.nextLine();
            System.out.print("price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("publishDate (yyyy-MM-dd): ");
            LocalDate pub = LocalDate.parse(scanner.nextLine());
            System.out.print("description: ");
            String desc = scanner.nextLine();

            Book b = new Book(id, title, author, price, pub, desc);
            bookService.addBook(b);
        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    private void actionCreateOrder() {
        try {
            System.out.print("bookId: ");
            int bookId = Integer.parseInt(scanner.nextLine());
            System.out.print("customerId: ");
            int cid = Integer.parseInt(scanner.nextLine());
            System.out.print("customerName: ");
            String name = scanner.nextLine();
            System.out.print("customerEmail: ");
            String email = scanner.nextLine();
            Customer c = new Customer(cid, name, email);
            orderService.createOrder(bookId, c);
        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    private void actionCompleteOrder() {
        try {
            System.out.print("orderId: ");
            int id = Integer.parseInt(scanner.nextLine());
            orderService.completeOrder(id);
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    private void actionCancelOrder() {
        try {
            System.out.print("orderId: ");
            int id = Integer.parseInt(scanner.nextLine());
            orderService.cancelOrder(id);
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    private void actionCreateRequest() {
        try {
            System.out.print("bookId: ");
            int id = Integer.parseInt(scanner.nextLine());
            requestService.createRequest(id);
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
}
