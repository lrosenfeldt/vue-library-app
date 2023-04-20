package com.lrosenfeldt.libraryservice.book.dtos.response;

import java.sql.Timestamp;
import java.util.Optional;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookOverviewDtoResponse {
    String title;
    Optional<Timestamp> lentUntil;
}
