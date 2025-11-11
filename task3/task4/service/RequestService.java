package task4.service;

import task4.model.Book;
import task4.model.Request;

public interface RequestService {
    Request createRequest(Book book);
    void closeRequestForBook(Book book);
}