package com.example.bookingservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ExceptionHanding {

    @ExceptionHandler
    public ResponseEntity<String> prepareResponseForDataNoFoundException(DataNoFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("DataNoFoundException: " + exception.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> prepareResponseForRunTimeException(RuntimeException exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("RunTimeException: " + exception.getMessage());
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> prepareResponseForIOException(IOException exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("RunTimeException: " + exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> prepareException(IOException exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Exception: " + exception.getMessage());
    }

}
