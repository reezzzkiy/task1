package task4.ui;

import task4.service.BookService;
import task4.service.OrderService;
import task4.service.RequestService;

import java.util.Scanner;

public class MenuController {
    private final Builder builder;
    private final Navigator navigator;
    private final Scanner scanner;

    private static volatile MenuController instance;

    private MenuController(BookService bookService, OrderService orderService, RequestService requestService) {
        this.scanner = new Scanner(System.in);
        this.builder = new Builder(bookService, orderService, requestService, scanner);
        this.navigator = new Navigator();
    }

    public static MenuController getInstance(BookService bookService, OrderService orderService,
            RequestService requestService) {
        if (instance == null) {
            synchronized (MenuController.class) {
                if (instance == null) {
                    instance = new MenuController(bookService, orderService, requestService);
                }
            }
        }
        return instance;
    }

    public void run() {
        builder.buildMenu();
        navigator.setCurrentMenu(builder.getRootMenu());

        while (true) {
            navigator.printMenu();
            String line = scanner.nextLine();
            int sel;
            try {
                sel = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
                continue;
            }

            if (sel == 0) {
                if (navigator.canGoBack()) {
                    navigator.goBack();
                    continue;
                } else {
                    System.out.println("Exit");
                    break;
                }
            }

            if (navigator.getCurrentMenu() != null) {
                if (sel >= 1 && sel <= navigator.getCurrentMenu().getMenuItems().size()) {
                    String title = navigator.getCurrentMenu().getMenuItems().get(sel - 1).getTitle();
                    if ("Exit".equalsIgnoreCase(title)) {
                        System.out.println("Exit");
                        break;
                    }
                }
            }

            navigator.navigate(sel);
        }
    }
}
