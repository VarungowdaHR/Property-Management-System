package com.properties.propertyManagementsystem.services;

import com.properties.propertyManagementsystem.dto.UserDTO;
import com.properties.propertyManagementsystem.entity.AddressEntity;
import com.properties.propertyManagementsystem.entity.UserEntity;

public interface UserBaseService {
    UserDTO login(UserDTO userdto);
    UserDTO register(UserDTO userdto);

    AddressEntity address(Long id);
}
