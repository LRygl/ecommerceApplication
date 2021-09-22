package com.application.ecommerce.Services;

import com.application.ecommerce.Model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product addNewProduct(String productName);
}
