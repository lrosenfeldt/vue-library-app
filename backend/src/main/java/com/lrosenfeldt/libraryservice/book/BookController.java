package com.lrosenfeldt.libraryservice.book;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lrosenfeldt.libraryservice.book.dtos.response.BookOverviewDtoResponse;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookTransformer bookTransformer;

    @GetMapping(path = "/{id}")
    @ResponseBody
    Optional<BookOverviewDtoResponse> getBookById(@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId).map(book -> bookTransformer.toBookOverview(book));
    }

    @GetMapping(path = "/all")
    @ResponseBody
    List<BookOverviewDtoResponse> getAllBooks() {
        return bookRepository.findAll().stream().map(book -> bookTransformer.toBookOverview(book))
                .collect(Collectors.toList());
    }
}
