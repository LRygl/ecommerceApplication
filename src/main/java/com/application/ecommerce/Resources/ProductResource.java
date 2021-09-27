package com.application.ecommerce.Resources;

import com.application.ecommerce.Model.HttpResponse;
import com.application.ecommerce.Model.Product;
import com.application.ecommerce.Services.ProductService;
import com.application.ecommerce.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
public class ProductResource {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/products/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
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

    @PostMapping(path = "products/update")
    public ResponseEntity<Product> updateProduct(@RequestParam("productName") String productName){
        Product updatedProduct = productService.updateProduct(productName);
        return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
    }

    @PostMapping(
            value = "/products/add",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product){
        Product newProduct = productService.addNewProduct(product.getProductName(),product.getProductNumber());
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }


    @DeleteMapping(path = "/products/delete/{id}")
    public ResponseEntity<HttpResponse> deleteUser(@PathVariable("id") Long Id){
        productService.deleteProduct(Id);
        return response(HttpStatus.NO_CONTENT,"Message");
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message){
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(),httpStatus,httpStatus.getReasonPhrase().toUpperCase(),message.toUpperCase()),httpStatus);
    }

}
