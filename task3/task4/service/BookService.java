package task4.service;

import task4.model.Book;

public interface BookService {
    void addBook(Book book);
    Book getBookById(int id);
    void updateBook(Book book);
}
