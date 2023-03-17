package com.properties.propertyManagementsystem.dto;

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
}
