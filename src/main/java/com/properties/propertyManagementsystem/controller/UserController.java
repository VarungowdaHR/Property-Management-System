package com.properties.propertyManagementsystem.controller;

import com.properties.propertyManagementsystem.dto.UserDTO;
import com.properties.propertyManagementsystem.services.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserBaseService userServce;

    @PostMapping("/user/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userdto){
        UserDTO loggedIn=userServce.login(userdto);
        return new ResponseEntity<>(loggedIn, HttpStatus.OK);

    }

    @PostMapping("/user/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userdto){
        UserDTO loggedIn=userServce.register(userdto);
        return new ResponseEntity<>(loggedIn, HttpStatus.CREATED);
    }



}
