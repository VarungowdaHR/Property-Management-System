package com.properties.propertyManagementsystem.repository;

import com.properties.propertyManagementsystem.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {
    List<PropertyEntity> findAllByUserEntityId(Long userId);
}
