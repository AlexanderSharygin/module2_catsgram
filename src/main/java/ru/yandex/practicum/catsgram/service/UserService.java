package ru.yandex.practicum.catsgram.service;

import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();


    public List<User> findAll() {
        return users;
    }


    public User create(User user) {
        if (!users.stream().filter(k -> k.getEmail().equals(user.getEmail())).collect(Collectors.toList()).isEmpty()) {
            throw new UserAlreadyExistException("UserIsAlreadyExist");
        } else if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new InvalidEmailException("email is null");
        }
        users.add(user);
        return user;
    }

    public Optional<User> update(User user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new InvalidEmailException("email is null");
        }

        Optional<User> oldUser = users.stream().filter(k -> k.getEmail().equals(k.getEmail())).findFirst();
        if (oldUser.isEmpty()) {
            throw new InvalidEmailException("email is not find");
        } else {
            oldUser.get().setNickname(user.getNickname());
            oldUser.get().setBirthdate(user.getBirthdate());
            return oldUser;
        }
    }

    public User findUserByEmail(String email) {
        if (email == null) {
            return null;
        }
        var user = users.stream().filter(k -> k.getEmail().equals(email)).findFirst();
        return user.orElse(null);
    }
}
