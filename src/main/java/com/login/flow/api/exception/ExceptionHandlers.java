package com.login.flow.api.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.login.flow.api.dto.ValidationDataDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleError400(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getFieldErrors();

        return ResponseEntity.badRequest().body(
                fieldErrors.stream()
                        .map(error -> new ValidationDataDTO(error.getField(), error.getDefaultMessage()))
                        .toList());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ValidationDataDTO> handleError403(BadCredentialsException exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ValidationDataDTO(exception.getMessage()));
    }

}
