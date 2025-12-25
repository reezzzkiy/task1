package task4;

import task4.model.*;
import task4.service.BookService;
import task4.enumerate.BookSortType;
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

                task4.ui.UIFactory uiFactory = new task4.ui.ConsoleUIFactory();
                task4.ui.MenuController controller = uiFactory.createMenuController(bookService, orderService,
                                requestService);
                controller.run();
        }
}
