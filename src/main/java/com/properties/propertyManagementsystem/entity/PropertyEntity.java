package com.properties.propertyManagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "PROPERTY_TITLE", nullable = false)
    private String title;
    private String description;
    private double cost;
    @Column(name="EMAIL", nullable = false)
    private String ownerMail;
    private String ownerName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="USER_ID", nullable = false)
    private UserEntity userEntity;
}
