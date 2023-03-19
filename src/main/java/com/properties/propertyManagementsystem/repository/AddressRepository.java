package com.properties.propertyManagementsystem.repository;

import com.properties.propertyManagementsystem.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressEntity, Long> {
    AddressEntity findByUserEntityId(Long id);
}
