package ru.yandex.practicum.catsgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping(value = {"/user/{email}"})
    public User getUserByEmail(@PathVariable("email") String email) {
        return userService.findUserByEmail(email);
    }

    @PostMapping(value = "/users")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping(value = "/users")
    public Optional<User> update(@RequestBody User user) {
        return userService.update(user);
    }
}
