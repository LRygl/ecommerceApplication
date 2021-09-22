package com.application.ecommerce.Resources;

import com.application.ecommerce.Model.Product;
import com.application.ecommerce.Services.ProductService;
import com.application.ecommerce.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class ProductResource {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/products/add")
    public ResponseEntity<Product> addNewProduct(@RequestParam("productname") String productName){
        Product newProduct = productService.addNewProduct(productName);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }


}
