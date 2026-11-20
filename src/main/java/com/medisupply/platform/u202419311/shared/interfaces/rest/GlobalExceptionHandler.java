package com.medisupply.platform.u202419311.shared.interfaces.rest;

import com.medisupply.platform.u202419311.shared.domain.BusinessConflictException;
import com.medisupply.platform.u202419311.shared.domain.DomainValidationException;
import com.medisupply.platform.u202419311.shared.interfaces.rest.resources.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Locale;

/**
 * Converts domain and application errors to localized HTTP responses.
 *
 * @author Matthew Shinko Okuhama Diaz
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final MessageSource messages;

    public GlobalExceptionHandler(MessageSource messages) {
        this.messages = messages;
    }

    @ExceptionHandler(DomainValidationException.class)
    public ResponseEntity<ApiError> domainError(DomainValidationException error, HttpServletRequest request) {
        return response(HttpStatus.BAD_REQUEST, error.getKey(), request);
    }

    @ExceptionHandler(BusinessConflictException.class)
    public ResponseEntity<ApiError> businessConflict(BusinessConflictException error, HttpServletRequest request) {
        return response(HttpStatus.CONFLICT, error.getMessage(), request);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiError> databaseConflict(DataIntegrityViolationException error, HttpServletRequest request) {
        // El índice UNIQUE también evita códigos repetidos.
        return response(HttpStatus.CONFLICT, "request.duplicate", request);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> invalidJson(HttpMessageNotReadableException error, HttpServletRequest request) {
        return response(HttpStatus.BAD_REQUEST, "request.invalid.json", request);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> invalidArgument(IllegalArgumentException error, HttpServletRequest request) {
        return response(HttpStatus.BAD_REQUEST, "request.invalid", request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> unexpected(Exception error, HttpServletRequest request) {
        return response(HttpStatus.INTERNAL_SERVER_ERROR, "request.unexpected", request);
    }

    private ResponseEntity<ApiError> response(HttpStatus status, String key, HttpServletRequest request) {
        Locale locale = "es".equalsIgnoreCase(request.getLocale().getLanguage())
                ? Locale.forLanguageTag("es")
                : Locale.ENGLISH;
        String message = messages.getMessage(key, null, key, locale);
        return ResponseEntity.status(status).body(new ApiError(message));
    }
}
