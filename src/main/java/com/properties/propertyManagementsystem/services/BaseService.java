package com.properties.propertyManagementsystem.services;
import com.properties.propertyManagementsystem.dto.PropertyDTO;
import com.properties.propertyManagementsystem.entity.PropertyEntity;
import com.properties.propertyManagementsystem.entity.UserEntity;
import org.springframework.stereotype.Service;
import java.util.List;
public interface BaseService {
    PropertyEntity saveRepo(PropertyDTO propertydto);
    List<PropertyEntity> listAllRepo();
    void deleteByIdREPO(Long id);
    PropertyEntity update(PropertyDTO propertydto, Long id);

    PropertyEntity updateName(Long id, String name);
    PropertyEntity updateCost(Long id, double cost);

}
