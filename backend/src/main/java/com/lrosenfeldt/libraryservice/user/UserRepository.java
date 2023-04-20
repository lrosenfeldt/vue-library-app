package com.lrosenfeldt.libraryservice.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lrosenfeldt.libraryservice.user.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
}
