package task4.model;

public class Book {
    private int id;
    private String title;
    private BookStatus status;

    public Book(int id, String title, BookStatus status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public BookStatus getStatus() { return status; }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', status=" + status + '}';
    }
}
