package com.properties.propertyManagementsystem.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AppException extends RuntimeException{
    private List<ErrorClass> errors;
    public AppException(List<ErrorClass> errors){
        this.errors=errors;
    }
}
