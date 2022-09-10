package ru.yandex.practicum.catsgram.controller;

public class UserAlreadyExistException extends  RuntimeException{
    public UserAlreadyExistException (String message) {
        super(message);
    }
}
