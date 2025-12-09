package task4.model;

import java.time.LocalDate;
import java.util.Objects;

public class Book {

    private int id;
    private String title;
    private String author;
    private double price;
    private BookStatus status;

    private LocalDate publishDate;
    private LocalDate arrivalDate;
    private LocalDate lastSoldDate;

    private String description;

    public Book(int id, String title, String author, double price, LocalDate publishDate, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.publishDate = publishDate;
        this.description = description;
        this.status = BookStatus.AVAILABLE;
        this.arrivalDate = LocalDate.now();
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public BookStatus getStatus() { return status; }
    public LocalDate getPublishDate() { return publishDate; }
    public LocalDate getArrivalDate() { return arrivalDate; }
    public LocalDate getLastSoldDate() { return lastSoldDate; }
    public String getDescription() { return description; }

    public void setStatus(BookStatus status) { this.status = status; }
    public void setPrice(double price) { this.price = price; }
    public void setLastSoldDate(LocalDate lastSoldDate) { this.lastSoldDate = lastSoldDate; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", arrival=" + arrivalDate +
                ", lastSold=" + lastSoldDate +
                '}';
    }
}
