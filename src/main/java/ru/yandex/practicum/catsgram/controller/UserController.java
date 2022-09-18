package ru.yandex.practicum.catsgram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UserController {
    UserService userService;

   @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return userService.findAll();
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
