package com.properties.propertyManagementsystem.services.converter;

import com.properties.propertyManagementsystem.dto.UserDTO;
import com.properties.propertyManagementsystem.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {
    public UserDTO entityToDto(UserEntity ue){
        UserDTO ud=new UserDTO();
        ud.setEmail(ue.getEmail());
        ud.setContact(ue.getContact());
        ud.setPassword(ue.getPassword());
        ud.setUserName(ue.getUserName());
        return ud;
    }

    public UserEntity dtoToEntity(UserDTO ud){
        UserEntity ue=new UserEntity();
        ue.setUserName(ud.getUserName());
        ue.setContact(ud.getContact());
        ue.setPassword(ud.getPassword());
        ue.setEmail(ud.getEmail());
        return  ue;
    }
}
