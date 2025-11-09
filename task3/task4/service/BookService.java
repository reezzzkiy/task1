package task4.service;

import task4.model.Book;

public interface BookService {
    Book findBookById(int id);
    void addBook(Book book);
    void setBookAvailable(int bookId);
    void setBookUnavailable(int bookId);
}
