package com.properties.propertyManagementsystem.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {
    private String title;
    private String description;
    private double cost;
    private String ownerMail;
    private String ownerName;


    @NotNull(message = "user id required")
    private Long userId;
}
