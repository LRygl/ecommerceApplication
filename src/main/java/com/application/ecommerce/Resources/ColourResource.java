package com.application.ecommerce.Resources;

import com.application.ecommerce.Model.HttpResponse;
import com.application.ecommerce.Model.Product;
import com.application.ecommerce.Model.ProductColour;
import com.application.ecommerce.Services.ProductColourService;
import jdk.javadoc.doclet.Reporter;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1")
public class ColourResource {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final ProductColourService productColourService;

    public ColourResource(ProductColourService productColourService) {
        this.productColourService = productColourService;
    }

    @GetMapping(value = "/colours")
    public ResponseEntity<HttpResponse> getAllProductColours(){
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("ProductColours",productColourService.getAllProductColours()))
                        .message("Message0")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping(
            value="/colours/add",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ProductColour addNewProductColour(@RequestBody ProductColour productColour){
        ProductColour newProductColour = productColourService.addNewProductColour(productColour);
        return null;
    }

    @GetMapping(value = "colours/{id}")
    private ResponseEntity<HttpResponse> findProductColourById(@PathVariable Long id){
        logger.info("Find product colour with ID = " + id);
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("ProductColour",productColourService.findProductColourById(id)))
                        .message("Located product with ID" + id)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PutMapping(value = "colours/update/{id}")
    public ResponseEntity<HttpResponse> updateProductColour(@RequestBody ProductColour productColour, @PathVariable Long id){
        productColourService.updateProductColour(id,productColour);
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Updated",productColourService.findProductColourById(id)))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping(path = "colours/delete/{id}")
    public ProductColour deleteProductColourById(@PathVariable("id") Long id){
        productColourService.deleteProductColourById(id);
        return null;
    }
}
