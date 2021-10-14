package com.application.ecommerce.Repository;

import com.application.ecommerce.Model.ProductManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManufacturerRepository extends JpaRepository<ProductManufacturer, Long> {
    ProductManufacturer findByProductManufacturerName(String productManufacturerName);
    Optional<ProductManufacturer> findById(Long id);
}
