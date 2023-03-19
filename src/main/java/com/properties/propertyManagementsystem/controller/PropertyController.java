package com.properties.propertyManagementsystem.controller;

import com.properties.propertyManagementsystem.dto.PropertyDTO;
import com.properties.propertyManagementsystem.entity.PropertyEntity;
import com.properties.propertyManagementsystem.services.PropertyBaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class PropertyController {
    @Autowired
    PropertyBaseService propertyService;

    @GetMapping("/")
    public String welcome(){
        return "welcome to my new page";
    }

    @PostMapping("/properties")
    public  ResponseEntity<PropertyEntity> save(@Valid @RequestBody PropertyDTO propertydto){
        PropertyEntity savedEntity=propertyService.saveRepo(propertydto);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyEntity>> listall(){
        List<PropertyEntity> list=propertyService.listAllRepo();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @DeleteMapping("/properties/{id}")
    public void delete(@PathVariable Long id){
        propertyService.deleteByIdREPO(id);
    }
    @PutMapping("/properties/{id}")
    public ResponseEntity<PropertyEntity> update(@RequestBody PropertyDTO propertyDTO, @PathVariable Long id){
        PropertyEntity updatedProperty= propertyService.update(propertyDTO, id);
        return new ResponseEntity<>(updatedProperty, HttpStatus.CREATED);
    }
    @PatchMapping("/properties/update-name/{id}")
    public ResponseEntity<PropertyEntity> updateOwnerName(@PathVariable Long id, @RequestParam String name){
        PropertyEntity updatedName= propertyService.updateName(id, name);
        return new ResponseEntity<>(updatedName, HttpStatus.CREATED);
    }

    @PatchMapping("/properties/update-cost/{id}")
    public  ResponseEntity<PropertyEntity> updateCost(@PathVariable Long id, @RequestParam Double cost){
        PropertyEntity updatedCost= propertyService.updateCost(id, cost);
        return new ResponseEntity<>(updatedCost, HttpStatus.CREATED);
    }
    @GetMapping("/properties/user/{userId}")
    public ResponseEntity<List<PropertyEntity>> findAll(@PathVariable Long userId){
        List<PropertyEntity> responce=propertyService.getUserProperties(userId);
        return new ResponseEntity<>(responce, HttpStatus.OK);
    }

}
