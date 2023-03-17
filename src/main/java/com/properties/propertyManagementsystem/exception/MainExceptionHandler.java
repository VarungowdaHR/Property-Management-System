package com.properties.propertyManagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.List;

@ControllerAdvice
public class MainExceptionHandler{
    @ExceptionHandler(AppException.class)
    public ResponseEntity<List<ErrorClass>> handleAppException(AppException ae){
        return new ResponseEntity<>(ae.getErrors(), HttpStatus.BAD_REQUEST);
    }

}
