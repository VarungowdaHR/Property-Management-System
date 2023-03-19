package com.properties.propertyManagementsystem.services.converter;

import com.properties.propertyManagementsystem.dto.UserDTO;
import com.properties.propertyManagementsystem.entity.AddressEntity;
import com.properties.propertyManagementsystem.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<Object> dtoToEntity(UserDTO ud){
        List<Object> arr=new ArrayList<>();
        UserEntity ue=new UserEntity();
        ue.setUserName(ud.getUserName());
        ue.setContact(ud.getContact());
        ue.setPassword(ud.getPassword());
        ue.setEmail(ud.getEmail());
        arr.add(ue);
        AddressEntity ae=new AddressEntity();
        ae.setCity(ud.getCity());
        ae.setState(ud.getState());
        ae.setCountry(ud.getCountry());
        ae.setPinCode(ud.getPinCode());
        ae.setHomeTown(ud.getHomeTown());
        ae.setUserEntity(ue);
        arr.add(ae);
        return arr;
    }
}
