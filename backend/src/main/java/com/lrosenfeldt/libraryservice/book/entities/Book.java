package com.lrosenfeldt.libraryservice.book.entities;

import java.sql.Timestamp;

import com.lrosenfeldt.libraryservice.user.entities.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "lentUntil")
    private Timestamp lentUntil;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User lentBy;
}
