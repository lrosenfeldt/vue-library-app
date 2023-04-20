package com.lrosenfeldt.libraryservice.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lrosenfeldt.libraryservice.user.dtos.response.LentBookDtoResponse;
import com.lrosenfeldt.libraryservice.user.entities.User;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTransformer userTransformer;

    @GetMapping(path = "/{id}")
    @ResponseBody
    Optional<User> getById(@PathVariable("id") Long userId) {
        return userRepository.findById(userId);
    }

    @GetMapping(path = "/{id}/books")
    @ResponseBody
    List<LentBookDtoResponse> getLentBooksForId(@PathVariable("id") Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            return userTransformer.toLentBooks(user.get());
        }
        return List.of();
    }
}
