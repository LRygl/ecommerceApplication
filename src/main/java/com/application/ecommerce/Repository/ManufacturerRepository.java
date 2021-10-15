package com.application.ecommerce.Repository;

import com.application.ecommerce.Model.ProductManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManufacturerRepository extends JpaRepository<ProductManufacturer, Long> {
    ProductManufacturer findByProductManufacturerName(String productManufacturerName);

    @Query(value = "SELECT pm.id AS id,pm.product_manufacturer_name AS product_manufacturer_name, pm.product_manufacturer_created as product_manufacturer_created FROM product_manufacturer AS pm WHERE pm.id = :id",nativeQuery = true)
    ProductManufacturer findManufacturerById(Long id);
}
