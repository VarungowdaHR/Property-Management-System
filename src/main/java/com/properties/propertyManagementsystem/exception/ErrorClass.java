package com.properties.propertyManagementsystem.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorClass {
    private String code;
    private String message;
}
