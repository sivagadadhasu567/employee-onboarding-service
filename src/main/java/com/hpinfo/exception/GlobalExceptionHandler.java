package com.hpinfo.exception;

import com.hpinfo.model.ErrorResponse;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataAccessException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleDataAccessException(DataAccessException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Database error occurred");
        errorResponse.setErrcode("ER001");
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse));
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleDuplicateKeyException(DuplicateKeyException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Database error occurred");
        errorResponse.setErrcode("ER001");
        return Mono.just(ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse));
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ErrorResponse>> handleException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Database error occurred");
        errorResponse.setErrcode("ER001");
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse));
    }

    @ExceptionHandler(EmployeeException.class)
    public Mono<ResponseEntity<String>> handleemployeeException(EmployeeException e) {
     EmployeeException employeeException = new EmployeeException();
        return Mono.just(ResponseEntity.internalServerError().body("unable to create the employee"));
    }

    @ExceptionHandler(PassWordMisMatchException.class)
    public Mono<ResponseEntity<String>> handleemployeeException(PassWordMisMatchException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Password and confirm password does not match");
        errorResponse.setErrcode("ER002");
        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password and confirm password does not match"));
    }
}
