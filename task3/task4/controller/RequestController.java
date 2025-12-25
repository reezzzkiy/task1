package task4.controller;

import task4.service.RequestService;

import java.util.Scanner;

public class RequestController {

    private final RequestService requestService;
    private final Scanner scanner;

    public RequestController(RequestService requestService, Scanner scanner) {
        this.requestService = requestService;
        this.scanner = scanner;
    }

    public void listAll() {
        requestService.getAllRequests().forEach(System.out::println);
    }

    public void createRequest() {
        try {
            System.out.print("bookId: ");
            int bookId = Integer.parseInt(scanner.nextLine());
            requestService.createRequest(bookId);
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
}
