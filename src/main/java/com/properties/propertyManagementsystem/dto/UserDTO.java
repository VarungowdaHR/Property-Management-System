package com.properties.propertyManagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    @NotNull(message = "email is required")
    @NotEmpty(message = "user name cannot be empty")
    @Size(min=1, max=50, message = "user name should contain 1 to 50 characters ")
    private String UserName;
    @NotNull(message = "password is required")
    @NotEmpty(message="password cannot be empty")
    private String password;
    private Long Contact;
    private String email;
    private String homeTown;
    private String City;
    private int pinCode;
    private String state;
    private String country;
}

