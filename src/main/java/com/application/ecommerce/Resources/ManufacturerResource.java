package com.application.ecommerce.Resources;

import com.application.ecommerce.Model.ProductManufacturer;
import com.application.ecommerce.Services.ManufacturerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
public class ManufacturerResource {

    private ManufacturerService manufacturerService;

    public ManufacturerResource(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/manufacturers")
    public ResponseEntity<List<ProductManufacturer>> getAllManufacturers(){
        List<ProductManufacturer> productManufacturers = manufacturerService.getAllManufacturers();
        return new ResponseEntity<>(productManufacturers, HttpStatus.OK);
    }

    @GetMapping("/manufacturers/{Id}")
    public  Optional<ProductManufacturer> getByProductManufacturerId(@PathVariable Long Id){
     Optional<ProductManufacturer> productManufacturers = manufacturerService.findById(Id);
       return productManufacturers;

    }

    @PostMapping("/manufacturers/add")
    public ResponseEntity<ProductManufacturer> addNewManufacturer(@RequestBody ProductManufacturer productManufacturer){
        ProductManufacturer newManufacturer = manufacturerService.addNewManufacturer(productManufacturer.getProductManufacturerName());
        return new ResponseEntity<>(newManufacturer, HttpStatus.CREATED);
    }



}
