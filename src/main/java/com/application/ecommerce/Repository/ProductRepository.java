package com.application.ecommerce.Repository;

import com.application.ecommerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductName(String productName);
    @Query(value = "SELECT * FROM product WHERE id = :id ",nativeQuery = true)
    Product findProductById(Long id);
}
