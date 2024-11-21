package org.faeriefit.microusers.advice;

import lombok.extern.slf4j.Slf4j;

import org.faeriefit.microutility.exception.ExistResourceException;
import org.faeriefit.microutility.exception.MessageError;
import org.faeriefit.microutility.exception.NotResourceException;
import org.faeriefit.microutility.exception.NotValidateParamException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ExceptionApiHandler {
    @ExceptionHandler(NotResourceException.class)
    public ResponseEntity<MessageError> notResource(NotResourceException exception){
        log.error(exception.getMessage(),exception);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(MessageError.of(exception.getMessage()));
    }

    @ExceptionHandler(ExistResourceException.class)
    public ResponseEntity<MessageError> notResource(ExistResourceException exception){
        log.error(exception.getMessage(),exception);
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(MessageError.of(exception.getMessage()));
    }

    @ExceptionHandler(NotValidateParamException.class)
    public ResponseEntity<MessageError> notResource(NotValidateParamException exception){
        log.error(exception.getMessage(),exception);
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .body(MessageError.of(exception.getMessage()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> validError(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName,message);
        });

        return errors;
    }
}
