package task4.ui;

import task4.controller.BookController;
import task4.controller.OrderController;
import task4.controller.RequestController;

public class Builder {

    private final Menu rootMenu = new Menu("Main Menu");

    private final BookController bookController;
    private final OrderController orderController;
    private final RequestController requestController;

    public Builder(BookController bookController,
                   OrderController orderController,
                   RequestController requestController) {
        this.bookController = bookController;
        this.orderController = orderController;
        this.requestController = requestController;
    }

    public void buildMenu() {
        rootMenu.addItem(new MenuItem("Books", null, buildBooksMenu()));
        rootMenu.addItem(new MenuItem("Orders", null, buildOrdersMenu()));
        rootMenu.addItem(new MenuItem("Requests", null, buildRequestsMenu()));
        rootMenu.addItem(new MenuItem("Exit", () -> System.out.println("Bye"), null));
    }

    public Menu getRootMenu() {
        return rootMenu;
    }


    private Menu buildBooksMenu() {
        Menu books = new Menu("Books");

        books.addItem(new MenuItem("List all books", bookController::listAll, null));
        books.addItem(new MenuItem("Add book", bookController::addBook, null));
        books.addItem(new MenuItem("List stale books (>6m)", bookController::listStale, null));
        books.addItem(new MenuItem("Back", null, null));

        return books;
    }


    private Menu buildOrdersMenu() {
        Menu orders = new Menu("Orders");

        orders.addItem(new MenuItem("List all orders", orderController::listAll, null));
        orders.addItem(new MenuItem("Create order", orderController::createOrder, null));
        orders.addItem(new MenuItem("Complete order", orderController::completeOrder, null));
        orders.addItem(new MenuItem("Cancel order", orderController::cancelOrder, null));
        orders.addItem(new MenuItem("Back", null, null));

        return orders;
    }


    private Menu buildRequestsMenu() {
        Menu requests = new Menu("Requests");

        requests.addItem(new MenuItem("List all requests", requestController::listAll, null));
        requests.addItem(new MenuItem("Create request", requestController::createRequest, null));
        requests.addItem(new MenuItem("Back", null, null));

        return requests;
    }
}
