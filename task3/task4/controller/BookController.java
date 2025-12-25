package task4.controller;

import task4.model.Book;
import task4.service.BookService;

import java.time.LocalDate;
import java.util.Scanner;

public class BookController {

    private final BookService bookService;
    private final Scanner scanner;

    public BookController(BookService bookService, Scanner scanner) {
        this.bookService = bookService;
        this.scanner = scanner;
    }

    public void listAll() {
        bookService.getAllBooks().forEach(System.out::println);
    }

    public void listStale() {
        bookService.getStaleBooks().forEach(System.out::println);
    }

    public void addBook() {
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
            LocalDate publishDate = LocalDate.parse(scanner.nextLine());

            System.out.print("description: ");
            String description = scanner.nextLine();

            Book book = new Book(id, title, author, price, publishDate, description);
            bookService.addBook(book);

        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
}
