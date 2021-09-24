package com.application.ecommerce.Services.ServiceImplementation;

import com.application.ecommerce.Model.ProductManufacturer;
import com.application.ecommerce.Repository.ManufacturerRepository;
import com.application.ecommerce.Repository.ProductRepository;
import com.application.ecommerce.Services.ManufacturerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@Qualifier("")
public class ManufacturerServiceImpl implements ManufacturerService {

    private ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<ProductManufacturer> getAllManufacturers() {return manufacturerRepository.findAll();}

    @Override
    public ProductManufacturer addNewManufacturer(String manufacturerName){
        ProductManufacturer productManufacturer = new ProductManufacturer();
        productManufacturer.setProductManufacturerName(manufacturerName);
        productManufacturer.setProductManufacturerCreated(new Date());
        manufacturerRepository.save(productManufacturer);
        return productManufacturer;
    }
}
