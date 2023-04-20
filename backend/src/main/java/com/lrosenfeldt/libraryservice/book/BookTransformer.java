package com.lrosenfeldt.libraryservice.book;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.lrosenfeldt.libraryservice.book.dtos.response.BookOverviewDtoResponse;
import com.lrosenfeldt.libraryservice.book.entities.Book;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class BookTransformer {

    BookOverviewDtoResponse toBookOverview(Book book) {
        return BookOverviewDtoResponse.builder().title(book.getTitle())
                .lentUntil(Optional.ofNullable(book.getLentUntil())).build();
    }
}
