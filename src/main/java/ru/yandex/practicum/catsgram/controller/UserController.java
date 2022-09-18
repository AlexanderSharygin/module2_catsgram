package ru.yandex.practicum.catsgram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UserController {


    private List<User> users = new ArrayList<>();

    @GetMapping("/users")
    public List<User> getAll() {
        return users;
    }



    @PostMapping(value = "/users")
    public User create(@RequestBody User user) {
        if (!users.stream().filter(k -> k.getEmail().equals(user.getEmail())).collect(Collectors.toList()).isEmpty()) {
            throw new UserAlreadyExistException("UserIsAlreadyExist");
        } else if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new InvalidEmailException("email is null");
        }
        users.add(user);
        return user;
    }

    @PutMapping(value = "/users")
    public Optional<User> update(@RequestBody User user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new InvalidEmailException("email is null");
        }

       Optional<User> oldUser = users.stream().filter(k->k.getEmail().equals(k.getEmail())).findFirst();
        if(oldUser.isEmpty())
        {
            throw new InvalidEmailException("email is not find");
        }
        else
        {
            oldUser.get().setNickname(user.getNickname());
            oldUser.get().setBirthdate(user.getBirthdate());
            return oldUser;
        }
    }
}
