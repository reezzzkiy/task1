package task4.model;

import java.time.LocalDate;

public class Request {

    private int id;
    private int bookId;
    private RequestStatus status;
    private LocalDate createdDate;

    public Request(int id, int bookId, LocalDate createdDate) {
        this.id = id;
        this.bookId = bookId;
        this.status = RequestStatus.OPEN;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public int getBookId() {
        return bookId;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void close() {
        this.status = RequestStatus.CLOSED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Request request))
            return false;
        return id == request.id;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", status=" + status +
                ", created=" + createdDate +
                '}';
    }

}