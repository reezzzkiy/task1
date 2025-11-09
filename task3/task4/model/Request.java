package task4.model;

public class Request {
    private int id;
    private int bookId;
    private RequestStatus status;

    public Request(int id, int bookId) {
        this.id = id;
        this.bookId = bookId;
        this.status = RequestStatus.OPEN;
    }

    public int getId() { return id; }
    public int getBookId() { return bookId; }
    public RequestStatus getStatus() { return status; }

    public void close() {
        this.status = RequestStatus.CLOSED;
    }

    @Override
    public String toString() {
        return "Request{id=" + id + ", bookId=" + bookId + ", status=" + status + "}";
    }
}
