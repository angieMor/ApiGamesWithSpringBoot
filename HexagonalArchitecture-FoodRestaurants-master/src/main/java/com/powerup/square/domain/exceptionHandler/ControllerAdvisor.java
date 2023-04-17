package com.powerup.square.domain.exceptionHandler;

import com.powerup.square.domain.exceptions.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@ResponseBody
public class ControllerAdvisor {

    private static final String MESSAGE = "message";

    // Some system general exceptions

    // MethodArgumentNotValidException -- To show shorter errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }

    // HttpRequestMethodNotSupportedException -- To show that the HTTP method used in request, is not supported
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseEntity<String> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        String message = "HTTP method not allowed";
        return new ResponseEntity<>(message, HttpStatus.METHOD_NOT_ALLOWED);
    }

    // Custom exceptions
    @ExceptionHandler(DateLaunchedProvidedIsNotADateTypeException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            DateLaunchedProvidedIsNotADateTypeException ignoredNoDataFoundException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, "DateLaunched provided needs to have the format yyyy-MM-dd"));
    }

    @ExceptionHandler(SexProvidedIsNotACharacterOnlyException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            SexProvidedIsNotACharacterOnlyException ignoredNoDataFoundException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, "Sex value provided, must be a single Character: F/M. F = Female, M = Male"));
    }

    @ExceptionHandler(SexProvidedDoesntExistException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            SexProvidedDoesntExistException ignoredNoDataFoundException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, "Sex value provided MUST BE F/M. F = Female, M = Male"));
    }

    @ExceptionHandler(GameNameProvidedDoesNotExistException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            GameNameProvidedDoesNotExistException ignoredNoDataFoundException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, "Game name provided does not exist, please provide an existing one :)"));
    }

    @ExceptionHandler(GameNameAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            GameNameAlreadyExistException ignoredNoDataFoundException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, "Game name already exist, please add a different game"));
    }

    @ExceptionHandler(PlayerFirstNameProvidedDoesNotExistException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            PlayerFirstNameProvidedDoesNotExistException ignoredNoDataFoundException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, "Player's First name provided does not exist, please provide an existing one :)"));
    }

    @ExceptionHandler(PlayerFirstNameAlreadyExist.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            PlayerFirstNameAlreadyExist ignoredNoDataFoundException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, "Player name already exist, please add a different player"));
    }

    @ExceptionHandler(HoursToRemoveShouldNotBeGreaterThanTheOnesRegisteredException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            HoursToRemoveShouldNotBeGreaterThanTheOnesRegisteredException ignoredNoDataFoundException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, "Hours to remove can't be greater than the ones registered"));
    }
}
