package ru.yandex.practicum.catsgram.controller;

public class InvalidEmailException extends  RuntimeException{
    public InvalidEmailException(String message) {
        super(message);
    }
}
