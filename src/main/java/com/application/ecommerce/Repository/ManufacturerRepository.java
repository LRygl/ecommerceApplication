package com.application.ecommerce.Repository;

import com.application.ecommerce.Model.ProductManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<ProductManufacturer, Long> {
    ProductManufacturer findByProductManufacturerName(String productManufacturerName);

}
