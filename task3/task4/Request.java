package task4;

public class Request {
    private Book book;

    public Request(Book book) {
        this.book = book;
        System.out.println("Создан запрос на книгу: " + book.getTitle());
    }

    public Book getBook() {
        return book;
    }
}