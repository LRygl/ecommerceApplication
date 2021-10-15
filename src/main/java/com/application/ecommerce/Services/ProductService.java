package com.application.ecommerce.Services;

import com.application.ecommerce.Model.Product;
import com.application.ecommerce.Model.Requests.ProductRequest;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts(int limit);

    Product findById(Long Id);

/*    Product addNewProduct(Product product);*/
    Product addNewProduct(ProductRequest product);
    Product findByProductName(String productName);

    void deleteProduct(Long Id);
}
