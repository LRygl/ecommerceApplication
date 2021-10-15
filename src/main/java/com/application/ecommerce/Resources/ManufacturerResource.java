package com.application.ecommerce.Resources;

import com.application.ecommerce.Model.ProductManufacturer;
import com.application.ecommerce.Services.ManufacturerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class ManufacturerResource {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private ManufacturerService manufacturerService;

    public ManufacturerResource(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/manufacturers")
    public ResponseEntity<List<ProductManufacturer>> getAllManufacturers(){
        List<ProductManufacturer> productManufacturers = manufacturerService.getAllManufacturers();
        return new ResponseEntity<>(productManufacturers, HttpStatus.OK);
    }

    @GetMapping("/manufacturers/findById/{id}")
    public ResponseEntity<ProductManufacturer> getManufacturerById(@PathVariable Long id){
        try{
            ProductManufacturer productManufacturer = manufacturerService.findManufacturerById(id);
            logger.info("FindByID Endpoint Hit with request - Requesting Manufacturer with Id = " + id);
            return new ResponseEntity<>(productManufacturer, HttpStatus.OK);
        } catch (Exception e){
            logger.info("Not Found");
            return null;
        }
    }

    @PostMapping("/manufacturers/add")
    public ResponseEntity<ProductManufacturer> addNewManufacturer(@RequestBody ProductManufacturer productManufacturer){
        ProductManufacturer newManufacturer = manufacturerService.addNewManufacturer(productManufacturer.getProductManufacturerName());
        return new ResponseEntity<>(newManufacturer, HttpStatus.CREATED);
    }



}
