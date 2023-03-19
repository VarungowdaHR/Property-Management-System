package com.properties.propertyManagementsystem.services.propertyservice;

import com.properties.propertyManagementsystem.dto.UserDTO;
import com.properties.propertyManagementsystem.entity.AddressEntity;
import com.properties.propertyManagementsystem.entity.UserEntity;
import com.properties.propertyManagementsystem.exception.AppException;
import com.properties.propertyManagementsystem.exception.ErrorClass;
import com.properties.propertyManagementsystem.repository.AddressRepository;
import com.properties.propertyManagementsystem.repository.UserRepository;
import com.properties.propertyManagementsystem.services.UserBaseService;
import com.properties.propertyManagementsystem.services.converter.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserBaseService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private AddressRepository addressRepo;

    @Autowired
    private UserConverter converter;

    @Override
    public UserDTO login(UserDTO userdto) {
        userRepo.findByUserNameAndPassword(userdto.getUserName(), userdto.getPassword())
                .orElseThrow(()->{
                    ErrorClass err=new ErrorClass();
                    err.setCode("USER_NOT_FOUND");
                    err.setMessage("Entered user name is not registerd.");
                    List<ErrorClass> errors=new ArrayList<>();
                    errors.add(err);
                    throw new AppException(errors);
                });
        return userdto;
    }


    @Override
    public UserDTO register(UserDTO userdto) {
        Optional<UserEntity> ue=userRepo.findByUserNameAndPassword(userdto.getUserName(), userdto.getPassword());
        if(ue.isPresent()){
            ErrorClass err=new ErrorClass();
            err.setCode("USER_EXIST");
            err.setMessage("Entered user name is already registerd");
            List<ErrorClass> errors=new ArrayList<>();
            errors.add(err);
            throw new AppException(errors);
        }
        List<Object> arr=converter.dtoToEntity(userdto);
        userRepo.save((UserEntity) arr.get(0));
        addressRepo.save((AddressEntity) arr.get(1));
       return userdto;
    }

    @Override
    public AddressEntity address(Long id){
        return addressRepo.findByUserEntityId(id);
    }

}
