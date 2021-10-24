package com.application.ecommerce.Resources;

import com.application.ecommerce.Model.HttpResponse;
import com.application.ecommerce.Model.ProductCategory;
import com.application.ecommerce.Model.ProductColour;
import com.application.ecommerce.Services.ProductCategoryService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1")
public class ProductCategoryResource {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private ProductCategoryService productCategoryService;

    public ProductCategoryResource(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping(value = "/category")
    public ResponseEntity<HttpResponse> getAllProductCategories(){
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("ProductCategories",productCategoryService.getAllProductCategories()))
                        .message("Product categories")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping(value = "/category/{id}")
    public ResponseEntity<HttpResponse> findProductCategoryById(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("ProductCategory",productCategoryService.findProductCategoryById(id)))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Product")
                        .build()
        );
    }

    @PostMapping(value = "/category/add")
    public ResponseEntity<HttpResponse> addNewProductCategory(@RequestBody ProductCategory productCategory){
        ProductCategory newProductCategory = productCategoryService.addNewProductCategory(productCategory);
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Category",newProductCategory))
                        .message("Category")
                        .statusCode(HttpStatus.CREATED.value())
                        .status(HttpStatus.CREATED)
                        .build()
        );
    }
    @PutMapping(value = "category/update/{id}")
    public ResponseEntity<HttpResponse> updateProductColour(@RequestBody ProductCategory productCategory, @PathVariable Long id){
        productCategoryService.updateProductCategoryById(id,productCategory);
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Updated",productCategoryService.findProductCategoryById(id)))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping(path = "category/delete/{id}")
    public ProductCategory deleteProductCategory(@PathVariable("id") Long id) {
        productCategoryService.deleteProductCategoryById(id);
        return null;
    }

}
