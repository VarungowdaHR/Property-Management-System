package com.properties.propertyManagementsystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    @NotNULL
    private String UserName;
    private String password;
    private Long Contact;
    private String email;
    private String homeTown;
    private String City;
    private int pinCode;
    private String state;
    private String country;
}

