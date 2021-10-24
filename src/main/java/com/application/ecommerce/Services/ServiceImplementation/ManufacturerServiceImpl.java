package com.application.ecommerce.Services.ServiceImplementation;

import com.application.ecommerce.Model.ProductManufacturer;
import com.application.ecommerce.Repository.ManufacturerRepository;
import com.application.ecommerce.Services.ManufacturerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<ProductManufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    @Override
    public ProductManufacturer addNewManufacturer(String manufacturerName){
        ProductManufacturer productManufacturer = new ProductManufacturer();
        productManufacturer.setProductManufacturerName(manufacturerName);
        productManufacturer.setProductManufacturerCreated(new Date());
        manufacturerRepository.save(productManufacturer);
        return productManufacturer;
    }

    @Override
    @Transactional
    public ProductManufacturer findManufacturerById(Long id) {
        ProductManufacturer productManufacturer = (ProductManufacturer) manufacturerRepository.findManufacturerById(id);
        if(productManufacturer == null){
            logger.info("No Manufacturer with ID = " + id + " was found - Return NotFoundException");
            throw new EntityNotFoundException("Not Found");
        } else {
            return productManufacturer;
        }
    }

    //TODO add deleteManufacturerById
    //TODO Add method for updateManufacturerById
}
