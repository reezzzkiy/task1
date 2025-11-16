package task4.service;

import task4.DataStorage;
import task4.model.*;

public class BookServiceImpl implements BookService {

    private final RequestService requestService;

    public BookServiceImpl(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public void addBook(Book book) {
        // закрываем открытые реквесты, если книга появилась
        requestService.closeRequests(book.getId());

        DataStorage.books.put(book.getId(), book);

        System.out.println("Добавлена книга: " + book);
    }

    @Override
    public Book getBookById(int id) {
        return DataStorage.books.get(id);
    }

    @Override
    public void updateBook(Book book) {
        DataStorage.books.put(book.getId(), book);
    }
}
