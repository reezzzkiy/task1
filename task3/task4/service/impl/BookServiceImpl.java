package task4.service.impl;

import task4.model.Book;
import task4.model.BookStatus;
import task4.service.BookService;
import task4.service.RequestService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {

    private final Map<Integer, Book> books = new HashMap<>();
    private final RequestService requestService;

    public BookServiceImpl(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public void addBook(Book book) {
        if (book.getStatus() == BookStatus.AVAILABLE) {
            requestService.closeRequests(book.getId());
        }
        books.put(book.getId(), book);
        System.out.println("Добавлена книга: " + book);
    }

    @Override
    public Optional<Book> getBookById(int id) {
        return Optional.ofNullable(books.get(id));
    }

    @Override
    public List<Book> getStaleBooks(int months) {
        LocalDate cutoff = LocalDate.now().minusMonths(months);
        return books.values().stream()
                .filter(book -> book.getLastSoldDate() == null || book.getLastSoldDate().isBefore(cutoff))
                .collect(Collectors.toList());
    }

    @Override
    public void updateBook(Book book) {
        books.put(book.getId(), book);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    @Override
    public List<Book> getBooksSortedByTitle() {
        return books.values().stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksSortedByDate() {
        return books.values().stream()
                .sorted(Comparator.comparing(Book::getArrivalDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksSortedByPrice() {
        return books.values().stream()
                .sorted(Comparator.comparingDouble(Book::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksSortedByAvailability() {
        return books.values().stream()
                .sorted(Comparator.comparing(Book::getStatus))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getStaleBooks() {
        LocalDate halfYearAgo = LocalDate.now().minusMonths(6);
        return books.values()
                .stream()
                .filter(book -> book.getLastSoldDate() == null
                        || book.getLastSoldDate().isBefore(halfYearAgo))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getStaleBooksSortedByArrivalDate() {
        return getStaleBooks().stream()
                .sorted(Comparator.comparing(Book::getArrivalDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getStaleBooksSortedByPrice() {
        return getStaleBooks().stream()
                .sorted(Comparator.comparing(Book::getPrice))
                .collect(Collectors.toList());
    }

}