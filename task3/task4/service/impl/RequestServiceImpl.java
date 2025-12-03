package task4.service.impl;

import task4.model.Request;
import task4.model.RequestStatus;
import task4.service.RequestService;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestServiceImpl implements RequestService {

    private final Map<Integer, Request> requests = new HashMap<>();
    private final AtomicInteger counter = new AtomicInteger(1);

    @Override
    public void createRequest(int bookId) {
        Request r = new Request(counter.getAndIncrement(), bookId, LocalDate.now());
        requests.put(r.getId(), r);
        System.out.println("Создан запрос: " + r);
    }

    @Override
    public boolean hasOpenRequest(int bookId) {
        return requests.values().stream()
                .anyMatch(r -> r.getBookId() == bookId && r.getStatus() == RequestStatus.OPEN);
    }

    @Override
    public void closeRequests(int bookId) {
        requests.values().forEach(r -> {
            if (r.getBookId() == bookId && r.getStatus() == RequestStatus.OPEN) {
                r.close();
                System.out.println("Закрыт запрос: " + r);
            }
        });
    }

    @Override
    public List<Request> getAllRequests() {
        return new ArrayList<>(requests.values());
    }

}