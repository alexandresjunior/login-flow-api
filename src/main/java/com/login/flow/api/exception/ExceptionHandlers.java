package com.login.flow.api.exception;

import java.nio.file.AccessDeniedException;
import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ValidationDataDTO> handleError400(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ValidationDataDTO("Erro: " + ex.getMessage() + "."));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ValidationDataDTO> handleError403(BadCredentialsException exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ValidationDataDTO(exception.getMessage()));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ValidationDataDTO> handleAuthenticationError() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ValidationDataDTO("Falha na autenticação."));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ValidationDataDTO> handleAcessDeniedError() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ValidationDataDTO("Acesso negado."));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ValidationDataDTO> handleError500(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ValidationDataDTO("Erro: " + ex.getLocalizedMessage() + "."));
    }

}
