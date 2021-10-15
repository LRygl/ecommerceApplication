package com.application.ecommerce.Services;

import com.application.ecommerce.Model.Product;
import com.application.ecommerce.Model.Requests.ProductRequest;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts(int limit);


/*    Product addNewProduct(Product product);*/
    Product addNewProduct(ProductRequest product);

    //FIND METHODS
    Product findByProductName(String productName);
    Product findProductById(Long id);


    void deleteProduct(Long Id);
}
