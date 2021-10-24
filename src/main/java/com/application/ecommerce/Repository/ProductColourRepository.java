package com.application.ecommerce.Repository;

import com.application.ecommerce.Model.ProductColour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductColourRepository extends JpaRepository<ProductColour,Long> {
    @Query(value = "SELECT * FROM product_colour WHERE id = :id ",nativeQuery = true)
    ProductColour findProductColourById(Long id);
}
