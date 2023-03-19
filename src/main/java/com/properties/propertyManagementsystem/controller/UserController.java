package com.properties.propertyManagementsystem.controller;

import com.properties.propertyManagementsystem.dto.UserDTO;
import com.properties.propertyManagementsystem.entity.AddressEntity;
import com.properties.propertyManagementsystem.entity.PropertyEntity;
import com.properties.propertyManagementsystem.services.PropertyBaseService;
import com.properties.propertyManagementsystem.services.UserBaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserBaseService userServce;


    @PostMapping("/login")
    public ResponseEntity<UserDTO> login( @Valid @RequestBody UserDTO userdto){
        UserDTO loggedIn=userServce.login(userdto);
        return new ResponseEntity<>(loggedIn, HttpStatus.OK);

    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO userdto){
        UserDTO loggedIn=userServce.register(userdto);
        return new ResponseEntity<>(loggedIn, HttpStatus.CREATED);
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressEntity>  address( @PathVariable Long id){
        AddressEntity response=userServce.address(id);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }



}
