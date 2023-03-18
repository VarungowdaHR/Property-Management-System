package com.properties.propertyManagementsystem.services.propertyservice;

import com.properties.propertyManagementsystem.dto.PropertyDTO;
import com.properties.propertyManagementsystem.entity.PropertyEntity;
import com.properties.propertyManagementsystem.entity.UserEntity;
import com.properties.propertyManagementsystem.exception.AppException;
import com.properties.propertyManagementsystem.exception.ErrorClass;
import com.properties.propertyManagementsystem.repository.PropertyRepository;
import com.properties.propertyManagementsystem.services.BaseService;
import com.properties.propertyManagementsystem.services.converter.PropertyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyService implements BaseService {
    @Autowired
    PropertyRepository propertyrepo;
    @Autowired
    PropertyConverter converter;
    @Override
    public PropertyEntity saveRepo(PropertyDTO propertydto) {
        PropertyEntity newEntity=converter.dtoToEntityConverter(propertydto);
        propertyrepo.save(newEntity);
        return newEntity;
    }

    @Override
    public List<PropertyEntity> listAllRepo() {
       return (List<PropertyEntity>) propertyrepo.findAll();
    }

    @Override
    public void deleteByIdREPO(Long id) {
        propertyrepo.deleteById(id);
    }

    @Override
    public PropertyEntity update(PropertyDTO propertydto, Long id) {
        PropertyEntity pe=null;
        Optional<PropertyEntity>  replaceEntity = propertyrepo.findById(id);
        if(replaceEntity.isPresent()){
            pe=replaceEntity.get();
            pe.setOwnerName(propertydto.getOwnerName());
            pe.setTitle(propertydto.getTitle());
            pe.setCost(propertydto.getCost());
            pe.setDescription(propertydto.getDescription());
            pe.setOwnerMail(propertydto.getOwnerMail());
            propertyrepo.save(pe);
        }else{
            List<ErrorClass> errors=new ArrayList<>();
            ErrorClass ec=new ErrorClass();
            ec.setCode("ID_NOT_FOUND");
            ec.setMessage("Id does not exist. Try to create new Property.");
            errors.add(ec);
            throw new AppException(errors);
        }
        return pe;
    }

    @Override
    public PropertyEntity updateName(Long id, String name) {
        PropertyEntity pe=null;
        Optional<PropertyEntity> optpe=propertyrepo.findById(id);
        if(optpe.isPresent()){
            pe=optpe.get();
            pe.setOwnerName(name);
            propertyrepo.save(pe);
        }else{
            List<ErrorClass> errors=new ArrayList<>();
            ErrorClass ec=new ErrorClass();
            ec.setCode("ID_NOT_FOUND");
            ec.setMessage("Id does not exist. Try to create new Property.");
            errors.add(ec);
            throw new AppException(errors);
        }
        return pe;
    }

    @Override
    public PropertyEntity updateCost(Long id, double cost) {
        PropertyEntity pe=null;
        Optional<PropertyEntity> optpe=propertyrepo.findById(id);
        if(optpe.isPresent()){
            pe=optpe.get();
            pe.setCost(cost);
            propertyrepo.save(pe);
        }else{
            List<ErrorClass> errors=new ArrayList<>();
            ErrorClass ec=new ErrorClass();
            ec.setCode("ID_NOT_FOUND");
            ec.setMessage("Id does not exist. Try to create new Property.");
            errors.add(ec);
            throw new AppException(errors);
        }
        return pe;
    }

}
