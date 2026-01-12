package task4.service.impl;

import task4.enumerate.BookSortType;
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
    public void updateBook(Book book) {
        books.put(book.getId(), book);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    @Override
    public List<Book> getBooks(BookSortType sortType) {
        Comparator<Book> comparator = switch (sortType) {
            case TITLE -> Comparator.comparing(Book::getTitle);
            case PRICE -> Comparator.comparing(Book::getPrice);
            case DATE_ADDED -> Comparator.comparing(Book::getArrivalDate);
            case AVAILABILITY -> Comparator.comparing(Book::getStatus);
            default -> null;
        };

        return books.values().stream()
                .sorted(comparator != null ? comparator : (a, b) -> 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getStaleBooks() {
        LocalDate halfYearAgo = LocalDate.now().minusMonths(6);

        return books.values()
                .stream()
                .filter(b -> b.getLastSoldDate() == null ||
                        b.getLastSoldDate().isBefore(halfYearAgo))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getStaleBooks(BookSortType sortType) {
        return getStaleBooks().stream()
                .sorted(getComparator(sortType))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getStaleBooks(int months) {
        LocalDate date = LocalDate.now().minusMonths(months);

        return books.values().stream()
                .filter(book -> book.getLastSoldDate() == null ||
                        book.getLastSoldDate().isBefore(date))
                .collect(Collectors.toList());
    }

    private Comparator<Book> getComparator(BookSortType sortType) {
        return switch (sortType) {
            case TITLE -> Comparator.comparing(Book::getTitle);
            case PRICE -> Comparator.comparing(Book::getPrice);
            case DATE_ADDED -> Comparator.comparing(Book::getArrivalDate);
            case AVAILABILITY -> Comparator.comparing(Book::getStatus);
            case NONE -> (a, b) -> 0;
        };
    }
}
