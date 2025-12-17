package task4.ui;

import task4.service.BookService;
import task4.service.OrderService;
import task4.service.RequestService;

public class ConsoleUIFactory implements UIFactory {
    @Override
    public MenuController createMenuController(BookService bookService, OrderService orderService,
            RequestService requestService) {
        return MenuController.getInstance(bookService, orderService, requestService);
    }

    @Override
    public Navigator createNavigator() {
        return new Navigator();
    }

    @Override
    public Builder createBuilder(BookService bookService, OrderService orderService, RequestService requestService) {
        return new Builder(bookService, orderService, requestService, new java.util.Scanner(System.in));
    }
}
