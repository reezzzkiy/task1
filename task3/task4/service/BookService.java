package task4.service;

import task4.enumerate.BookSortType;
import task4.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {

    void addBook(Book book);

    Optional<Book> getBookById(int id);

    void updateBook(Book book);

    List<Book> getAllBooks();

    List<Book> getBooks(BookSortType sortType);

    List<Book> getStaleBooks();

    List<Book> getStaleBooks(int months);

    List<Book> getStaleBooks(BookSortType sortType);
}