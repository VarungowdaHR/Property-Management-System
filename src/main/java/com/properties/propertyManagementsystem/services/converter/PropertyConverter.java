package com.properties.propertyManagementsystem.services.converter;

import com.properties.propertyManagementsystem.dto.PropertyDTO;
import com.properties.propertyManagementsystem.entity.PropertyEntity;
import org.springframework.stereotype.Service;

@Service
public class PropertyConverter {
    public PropertyEntity dtoToEntityConverter(PropertyDTO propertydto){
        PropertyEntity newEntity=new PropertyEntity();
        newEntity.setCost(propertydto.getCost());
        newEntity.setDescription(propertydto.getDescription());
        newEntity.setOwnerMail(propertydto.getOwnerMail());
        newEntity.setTitle(propertydto.getTitle());
        newEntity.setOwnerName(propertydto.getOwnerName());
        return newEntity;
    }
    public PropertyDTO entityToDtoConverter(PropertyEntity propertyEntity){
        PropertyDTO newDto=new PropertyDTO();
        newDto.setCost(propertyEntity.getCost());
        newDto.setDescription(propertyEntity.getDescription());
        newDto.setOwnerMail(propertyEntity.getOwnerMail());
        newDto.setTitle(propertyEntity.getTitle());
        newDto.setOwnerName(propertyEntity.getOwnerName());
        return newDto;
    }

}
