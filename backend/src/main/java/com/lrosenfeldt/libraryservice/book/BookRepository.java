package com.lrosenfeldt.libraryservice.book;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lrosenfeldt.libraryservice.book.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findById(Long id);

    List<Book> findAll();
}
