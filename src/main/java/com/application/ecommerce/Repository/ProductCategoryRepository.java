package com.application.ecommerce.Repository;

import com.application.ecommerce.Model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    @Query(value = "SELECT * FROM product_category WHERE id = :id ",nativeQuery = true)
    ProductCategory findProductCategoryById(Long id);

}
