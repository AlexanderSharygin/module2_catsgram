package ru.yandex.practicum.catsgram.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.yandex.practicum.catsgram.exception.*;
import ru.yandex.practicum.catsgram.model.ErrorResponse;

@ControllerAdvice(assignableTypes = {PostController.class, PostFeedController.class})
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlePostNotFoundException(final PostNotFoundException e) {
        return new ErrorResponse(
                e.getMessage(), "Description"
        );
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleUserNotFoundException(final UserNotFoundException e) {
        return new ErrorResponse(
                e.getMessage(), "Description"
        );
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleUserAlreadyExistException(final UserAlreadyExistException e) {
        return new ErrorResponse(e.getMessage(), "User is already exist");
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidEmailException(final InvalidEmailException e) {
        return new ErrorResponse(e.getMessage(), "Email is invalid");
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleIncorrectParameterException(final IncorrectParameterException e) {
        return new ErrorResponse(e.getMessage(), "Invalid parameter - " + e.getParameter());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleOtherExceptions(final Throwable e) {
        return new ErrorResponse(e.getMessage(), "Произошла непредвиденная ошибка.");
    }

}


