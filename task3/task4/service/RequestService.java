package task4.service;

public interface RequestService {
    void createRequest(int bookId);
    boolean hasOpenRequest(int bookId);
    void closeRequests(int bookId);
}