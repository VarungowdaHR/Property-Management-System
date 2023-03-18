package com.properties.propertyManagementsystem.repository;

import com.properties.propertyManagementsystem.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserNameAndPassword(String userName, String password);
}
