package com.lrosenfeldt.libraryservice.user.dtos.response;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LentBookDtoResponse {
    String title;
    Timestamp lentUntil;
}
