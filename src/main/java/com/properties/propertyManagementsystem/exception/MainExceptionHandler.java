package com.properties.propertyManagementsystem.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MainExceptionHandler{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(AppException.class)
    public ResponseEntity<List<ErrorClass>> handleAppException(AppException ae){
        return new ResponseEntity<>(ae.getErrors(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorClass>> handleFieldError(MethodArgumentNotValidException fieldException){
        List<FieldError> fieldErrors=fieldException.getBindingResult().getFieldErrors();
        List<ErrorClass> errors=new ArrayList<>();
        for(FieldError i:fieldErrors){
            logger.debug("field validation: {} - {}", i.getField(), i.getDefaultMessage());
            logger.info("field validation: {} - {}", i.getField(), i.getDefaultMessage());
            ErrorClass err=new ErrorClass();
            err.setMessage(i.getDefaultMessage());
            err.setCode(i.getCode());
            errors.add(err);
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }

}
