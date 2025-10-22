package task4;

public class Book {
    private String title;
    private boolean available; 

    public Book(String title, boolean available) {
        this.title = title;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
        System.out.println("Книга \"" + title + "\" теперь " + (available ? "в наличии." : "отсутствует."));
    }

    @Override
    public String toString() {
        return title + " (" + (available ? "в наличии" : "отсутствует") + ")";
    }
}
