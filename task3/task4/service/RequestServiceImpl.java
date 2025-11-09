package task4.service;

import task4.DataStorage;
import task4.model.*;

public class RequestServiceImpl implements RequestService {

    private int requestCounter = 1;

    @Override
    public void createRequest(int bookId) {
        Request req = new Request(requestCounter++, bookId);
        DataStorage.requests.put(req.getId(), req);

        System.out.println("Создан запрос: " + req);
    }

    @Override
    public boolean hasOpenRequest(int bookId) {
        return DataStorage.requests
                .values()
                .stream()
                .anyMatch(r -> r.getBookId() == bookId && r.getStatus() == RequestStatus.OPEN);
    }

    @Override
    public void closeRequests(int bookId) {
        DataStorage.requests.values().forEach(r -> {
            if (r.getBookId() == bookId && r.getStatus() == RequestStatus.OPEN) {
                r.close();
                System.out.println("Закрыт запрос: " + r);
            }
        });
    }
}