package task4.service;

import task4.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {

    void addBook(Book book);

    Optional<Book> getBookById(int id);

    void updateBook(Book book);

    List<Book> getAllBooks();

    List<Book> getBooksSortedByTitle();

    List<Book> getBooksSortedByDate();

    List<Book> getBooksSortedByPrice();

    List<Book> getBooksSortedByAvailability();

    List<Book> getStaleBooks();

    List<Book> getStaleBooksSortedByArrivalDate();

    List<Book> getStaleBooksSortedByPrice();

    List<Book> getStaleBooks(int months);

}