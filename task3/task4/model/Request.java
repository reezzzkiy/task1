package task4.model;

public class Request {
    private final int id;
    private final Book book;
    private boolean isOpen;

    public Request(int id, Book book) {
        this.id = id;
        this.book = book;
        this.isOpen = true;
    }

    public int getId() { return id; }
    public Book getBook() { return book; }
    public boolean isOpen() { return isOpen; }

    public void close() { this.isOpen = false; }

    @Override
    public String toString() {
        return "Request #" + id + " [book=" + book.getTitle() + ", open=" + isOpen + "]";
    }
}
