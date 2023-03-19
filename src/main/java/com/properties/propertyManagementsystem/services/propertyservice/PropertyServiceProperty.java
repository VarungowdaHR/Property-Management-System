package com.properties.propertyManagementsystem.services.propertyservice;

import com.properties.propertyManagementsystem.dto.PropertyDTO;
import com.properties.propertyManagementsystem.entity.PropertyEntity;
import com.properties.propertyManagementsystem.entity.UserEntity;
import com.properties.propertyManagementsystem.exception.AppException;
import com.properties.propertyManagementsystem.exception.ErrorClass;
import com.properties.propertyManagementsystem.repository.PropertyRepository;
import com.properties.propertyManagementsystem.repository.UserRepository;
import com.properties.propertyManagementsystem.services.PropertyBaseService;
import com.properties.propertyManagementsystem.services.converter.PropertyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceProperty implements PropertyBaseService {
    @Autowired
    PropertyRepository propertyRepo;

    @Autowired
    UserRepository userEntityRepo;
    @Autowired
    PropertyConverter converter;
    @Override
    public PropertyEntity saveRepo(PropertyDTO propertydto) {
        Optional<UserEntity> ue=userEntityRepo.findById(propertydto.getUserId());
        if(ue.isPresent()){
            PropertyEntity newEntity=converter.dtoToEntityConverter(propertydto);
            newEntity.setUserEntity(ue.get());
            propertyRepo.save(newEntity);
            return newEntity;
        }
        ErrorClass ec=new ErrorClass();
        ec.setCode("USER_NOT_REGISTERED");
        ec.setMessage("Please register to continue..");
        ArrayList<ErrorClass> errors=new ArrayList<>();
        errors.add(ec);
        throw new AppException(errors);
    }

    @Override
    public List<PropertyEntity> listAllRepo() {
       return (List<PropertyEntity>) propertyRepo.findAll();
    }

    @Override
    public void deleteByIdREPO(Long id) {
        propertyRepo.deleteById(id);
    }

    @Override
    public PropertyEntity update(PropertyDTO propertydto, Long id) {
        PropertyEntity pe=null;
        Optional<PropertyEntity>  replaceEntity = propertyRepo.findById(id);
        if(replaceEntity.isPresent()){
            pe=replaceEntity.get();
            pe.setOwnerName(propertydto.getOwnerName());
            pe.setTitle(propertydto.getTitle());
            pe.setCost(propertydto.getCost());
            pe.setDescription(propertydto.getDescription());
            pe.setOwnerMail(propertydto.getOwnerMail());
            propertyRepo.save(pe);
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
        Optional<PropertyEntity> optpe= propertyRepo.findById(id);
        if(optpe.isPresent()){
            pe=optpe.get();
            pe.setOwnerName(name);
            propertyRepo.save(pe);
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
        Optional<PropertyEntity> optpe= propertyRepo.findById(id);
        if(optpe.isPresent()){
            pe=optpe.get();
            pe.setCost(cost);
            propertyRepo.save(pe);
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
    public List<PropertyEntity> getUserProperties(Long id){
        return propertyRepo.findAllByUserEntityId(id);
    }

}
