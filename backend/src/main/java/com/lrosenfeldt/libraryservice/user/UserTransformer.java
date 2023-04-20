package com.lrosenfeldt.libraryservice.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.lrosenfeldt.libraryservice.user.dtos.response.LentBookDtoResponse;
import com.lrosenfeldt.libraryservice.user.entities.User;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class UserTransformer {

    List<LentBookDtoResponse> toLentBooks(User user) {
        return user.getLentBooks().stream()
                .map(book -> LentBookDtoResponse.builder().title(book.getTitle()).lentUntil(book.getLentUntil())
                        .build())
                .collect(Collectors.toList());
    }

}
