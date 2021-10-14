package com.application.ecommerce.Resources;

import com.application.ecommerce.Model.HttpResponse;
import com.application.ecommerce.Model.Product;
import com.application.ecommerce.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class ProductResource {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

/*    @GetMapping(path = "/products/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }*/

    @GetMapping(path = "/products/all")
    public ResponseEntity<HttpResponse> getAllProducts(){
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("products",productService.getAllProducts(30)))
                        .message("Servers retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping(path = "/products")
    public ResponseEntity<Product> getProduct(@RequestParam(name = "name") String productName){
        Product product = productService.findByProductName(productName);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping(path = "/products/{Id}")
    public Optional<Product> getProductById(@PathVariable Long Id){
        Optional<Product> product = productService.findById(Id);
        return product;
    }

    @PostMapping(
            value = "/products/add",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product){
        Product newProduct = productService.addNewProduct(product.getProductName(),product.getProductNumber());
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }


/*    @DeleteMapping(path = "/products/delete/{id}")
    public ResponseEntity<HttpResponse> deleteUser(@PathVariable("id") Long Id){
        productService.deleteProduct(Id);
        return response(HttpStatus.NO_CONTENT,"Message");
    }
    */
}
