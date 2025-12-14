package task4.service;

import task4.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {

    enum SortType {
        TITLE,
        PRICE,
        DATE_ADDED,
        AVAILABILITY,
        NONE
    }

    void addBook(Book book);
    Optional<Book> getBookById(int id);
    void updateBook(Book book);
    List<Book> getAllBooks();

    List<Book> getBooks(SortType sortType);

    List<Book> getStaleBooks();
    List<Book> getStaleBooks(int months);
    List<Book> getStaleBooks(SortType sortType);
}