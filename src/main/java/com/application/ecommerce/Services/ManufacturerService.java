package com.application.ecommerce.Services;

import com.application.ecommerce.Model.ProductManufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {
    public List<ProductManufacturer> getAllManufacturers();
   /* ProductManufacturer findById(Long Id);*/
    ProductManufacturer addNewManufacturer(String manufacturerName);
    ProductManufacturer findManufacturerById(Long id);
}
