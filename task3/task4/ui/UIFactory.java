package task4.ui;

import task4.service.BookService;
import task4.service.OrderService;
import task4.service.RequestService;

public interface UIFactory {
    MenuController createMenuController(BookService bookService, OrderService orderService,
            RequestService requestService);

    Navigator createNavigator();

    Builder createBuilder(BookService bookService, OrderService orderService, RequestService requestService);
}
