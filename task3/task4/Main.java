package task4;

public class Main {
    public static void main(String[] args) {
        BookStore store = new BookStore();

        store.addBook(new Book("Head First Java", true));
        store.addBook(new Book("Java для чайников", false));
        store.addBook(new Book("Java. Руководство для начинающих", true));

        Order o1 = store.createOrder("Head First Java");
        Order o2 = store.createOrder("Java для чайников"); 
        store.showStatus();

        store.completeOrder(o1); 
        store.completeOrder(o2); 
        store.showStatus();

        store.addBookToStock("Java для чайников"); 
        store.completeOrder(o2); 
        store.showStatus();
    }
}