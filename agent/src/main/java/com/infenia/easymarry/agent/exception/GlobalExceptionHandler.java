package com.infenia.easymarry.agent.exception;

import jakarta.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Custom error response
class ErrorResponse {
  private String error;
  private String message;
  private int status;
  private LocalDateTime timestamp;

  public ErrorResponse(String error, String message, int status) {
    this.error = error;
    this.message = message;
    this.status = status;
    this.timestamp = LocalDateTime.now();
  }

  // getters
  public String getError() {
    return error;
  }

  public String getMessage() {
    return message;
  }

  public int getStatus() {
    return status;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }
}

@ControllerAdvice
public class GlobalExceptionHandler {

  // 1. Resource Not Found → 404
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
    ErrorResponse error =
        new ErrorResponse("NOT_FOUND", ex.getMessage(), HttpStatus.NOT_FOUND.value());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  // 2. Validation Error → 400
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
    FieldError fieldError = ex.getBindingResult().getFieldError();
    String errorMessage = (fieldError != null) ? fieldError.getDefaultMessage() : "Invalid input";
    ErrorResponse error =
        new ErrorResponse("VALIDATION_ERROR", errorMessage, HttpStatus.BAD_REQUEST.value());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  // 3a. IllegalArgumentException → 400
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {
    ErrorResponse error =
        new ErrorResponse("BAD_REQUEST", ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  // 3b. ConstraintViolationException → 400
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException ex) {
    ErrorResponse error =
        new ErrorResponse("CONSTRAINT_VIOLATION", ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  // 4a. AccessDeniedException → 403
  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity<ErrorResponse> handleAccessDenied(AccessDeniedException ex) {
    ErrorResponse error =
        new ErrorResponse("FORBIDDEN", "Access is denied", HttpStatus.FORBIDDEN.value());
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
  }

  // 4b. AuthenticationException → 401
  @ExceptionHandler(AuthenticationException.class)
  public ResponseEntity<ErrorResponse> handleAuthentication(AuthenticationException ex) {
    ErrorResponse error =
        new ErrorResponse("UNAUTHORIZED", "Authentication failed", HttpStatus.UNAUTHORIZED.value());
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
  }

  // 5. Generic Fallback → 500
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
    ErrorResponse error =
        new ErrorResponse(
            "INTERNAL_SERVER_ERROR", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }
}
