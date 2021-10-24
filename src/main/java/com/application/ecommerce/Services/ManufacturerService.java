package com.application.ecommerce.Services;

import com.application.ecommerce.Model.ProductManufacturer;

import java.util.List;

public interface ManufacturerService {
    List<ProductManufacturer> getAllManufacturers();

    ProductManufacturer addNewManufacturer(String manufacturerName);
    ProductManufacturer findManufacturerById(Long id);
}
