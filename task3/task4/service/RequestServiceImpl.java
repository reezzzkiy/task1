package task4.service;

import task4.model.Book;
import task4.model.Request;
import java.util.HashMap;
import java.util.Map;

public class RequestServiceImpl implements RequestService {
    private final Map<Integer, Request> requests = new HashMap<>();
    private int requestCounter = 1;

    @Override
    public Request createRequest(Book book) {
        Request request = new Request(requestCounter++, book);
        requests.put(request.getId(), request);
        System.out.println("Создан запрос #" + request.getId() + " на книгу \"" + book.getTitle() + "\".");
        return request;
    }

    @Override
    public void closeRequestForBook(Book book) {
        for (Request r : requests.values()) {
            if (r.getBook().equals(book) && r.isOpen()) {
                r.close();
                System.out.println("Запрос #" + r.getId() + " на книгу \"" + book.getTitle() + "\" закрыт.");
            }
        }
    }
}
