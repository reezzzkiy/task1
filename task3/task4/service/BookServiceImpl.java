package task4.service;

import task4.model.Book;
import task4.model.BookStatus;
import java.util.HashMap;
import java.util.Map;

public class BookServiceImpl implements BookService {
    private final Map<Integer, Book> books = new HashMap<>();

    @Override
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    @Override
    public Book findBookById(int id) {
        return books.get(id);
    }

    @Override
    public void setBookAvailable(int bookId) {
        Book book = books.get(bookId);
        if (book != null) {
            book.setStatus(BookStatus.AVAILABLE);
            System.out.println("Книга \"" + book.getTitle() + "\" теперь в наличии.");
        }
    }

    @Override
    public void setBookUnavailable(int bookId) {
        Book book = books.get(bookId);
        if (book != null) {
            book.setStatus(BookStatus.UNAVAILABLE);
            System.out.println("Книга \"" + book.getTitle() + "\" списана со склада.");
        }
    }
}
