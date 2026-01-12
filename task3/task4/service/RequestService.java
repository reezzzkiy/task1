package task4.service;

import task4.enumerate.RequestSortType;
import task4.model.Request;
import java.util.List;

public interface RequestService {

    void createRequest(int bookId);

    boolean hasOpenRequest(int bookId);

    void closeRequests(int bookId);

    List<Request> getAllRequests();

    List<Request> getRequests(RequestSortType sortType);
}