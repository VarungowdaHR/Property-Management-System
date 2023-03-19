package com.properties.propertyManagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Digits;
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
    @NotNull(message = "email is required")
    @NotEmpty(message="email cannot be empty")
    private String email;

    private String homeTown;

    private String City;
    @NotNull(message = "pincode is required")
    @Digits(integer = 6, fraction = 0, message = "pincode must be an integer and should contain six digits")
    private Integer pinCode;
    @NotNull(message = "state is required")
    @NotEmpty(message="state cannot be empty")
    private String state;
    @NotNull(message = "country is required")
    @NotEmpty(message="country cannot be empty")
    private String country;
}

