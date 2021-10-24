package com.application.ecommerce.Resources;

import com.application.ecommerce.Model.HttpResponse;
import com.application.ecommerce.Model.ProductManufacturer;
import com.application.ecommerce.Services.ManufacturerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1")
public class ManufacturerResource {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private ManufacturerService manufacturerService;

    public ManufacturerResource(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/manufacturers")
    public ResponseEntity<HttpResponse> getAllManufacturers(){
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("manufacturers",manufacturerService.getAllManufacturers()))
                        .message("Message0")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/manufacturers/findById/{id}")
    public ResponseEntity<HttpResponse> getManufacturerById(@PathVariable Long id){
        try{
/*          ProductManufacturer productManufacturer = manufacturerService.findManufacturerById(id);
            logger.info("FindByID Endpoint Hit with request - Requesting Manufacturer with Id = " + id);
            return new ResponseEntity<>(productManufacturer, HttpStatus.OK);*/
            logger.info("Info get by Id " + id);
            return ResponseEntity.ok(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now())
                            .data(Map.of("manufacturer",manufacturerService.findManufacturerById(id)))
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );

        } catch (Exception e){
            logger.info("Not Found");
            return null;
        }
    }
/*
    @PostMapping("/manufacturers/add")
    public ResponseEntity<ProductManufacturer> addNewManufacturer(@RequestBody ProductManufacturer productManufacturer){
        ProductManufacturer newManufacturer = manufacturerService.addNewManufacturer(productManufacturer.getProductManufacturerName());
        return new ResponseEntity<>(newManufacturer, HttpStatus.CREATED);
    }*/

    @PostMapping("/manufacturers/add")
    public ResponseEntity<HttpResponse> addNewManufacturer(@RequestBody ProductManufacturer productManufacturer){
        ProductManufacturer newManufacturer = manufacturerService.addNewManufacturer(productManufacturer.getProductManufacturerName());
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("newManufacturer",newManufacturer))
                        .statusCode(HttpStatus.CREATED.value())
                        .status(HttpStatus.CREATED)
                        .build()
        );
    }



}
