package com.lrosenfeldt.libraryservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleBooksController {

    @GetMapping("/example-books")
    public List<ExampleBook> exampleBooks() {
        List<ExampleBook> books = new ArrayList<>();
        books.add(new ExampleBook(1, "Leviathan fällt", "James Corey"));
        books.add(new ExampleBook(2, "Supernova", "Cixin Liu"));
        books.add(new ExampleBook(3, "Stalker", "Boris Strugazki"));
        books.add(new ExampleBook(4, "1984", "George Orwell"));

        return books;
    }
}
