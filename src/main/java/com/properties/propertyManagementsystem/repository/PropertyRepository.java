package com.properties.propertyManagementsystem.repository;

import com.properties.propertyManagementsystem.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {
}
