package com.application.ecommerce.Services;

import com.application.ecommerce.Model.ProductManufacturer;

import java.util.List;

public interface ManufacturerService {
    public List<ProductManufacturer> getAllManufacturers();
/*
    <Optional> Object findById(Long Id);
*/
    ProductManufacturer addNewManufacturer(String manufacturerName);
    ProductManufacturer findManufacturerById(Long id);
}
