package com.service.benitez.scotibank.challenge.controller;

import com.service.benitez.scotibank.challenge.model.dto.ErrorDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ChallengeExceptionHandler {

    @ExceptionHandler(value = WebExchangeBindException.class)
    public ResponseEntity<ErrorDto> businessExceptionHandler(WebExchangeBindException ex) {
        String nameField = ex.getFieldError().getField();
        String message = ex.getFieldError().getDefaultMessage();
        ErrorDto error = new ErrorDto(
                "RB001.01",
                nameField.concat(": ").concat(message),
                ex.getStatusCode().value(),
                LocalDateTime.now().toString());
        return new ResponseEntity<>(error, ex.getStatusCode());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ErrorDto> handleConstraintViolationException(ConstraintViolationException ex) {
        ErrorDto error = new ErrorDto(
                "Constraint Violation",
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now().toString());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = IllegalStateException.class)
    public ResponseEntity<ErrorDto> handleIllegalStateException(IllegalStateException ex) {
        ErrorDto error = new ErrorDto(
                "RB002.01",
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now().toString());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /*

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleGenericException(Exception ex) {
        ErrorDto error = new ErrorDto(
                "Unknown Error",
                ex.getMessage(),
                null,
                LocalDateTime.now().toString());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/
}
