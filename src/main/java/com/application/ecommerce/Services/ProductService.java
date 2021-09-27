package com.application.ecommerce.Services;

import com.application.ecommerce.Model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> findById(Long Id);

    Product updateProduct(String productName);
    Product addNewProduct(String productName, String productNumber);
    Product findByProductName(String productName);

    void deleteProduct(Long Id);
}
