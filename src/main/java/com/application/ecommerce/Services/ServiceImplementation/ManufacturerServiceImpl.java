package com.application.ecommerce.Services.ServiceImplementation;

import com.application.ecommerce.Model.ProductManufacturer;
import com.application.ecommerce.Repository.ManufacturerRepository;
import com.application.ecommerce.Services.ManufacturerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private ManufacturerRepository manufacturerRepository;
    private final EntityManager entityManager;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository, EntityManager entityManager) {
        this.manufacturerRepository = manufacturerRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<ProductManufacturer> getAllManufacturers() {return manufacturerRepository.findAll();}

/*    @Override
    public ProductManufacturer findById(Long Id){
        return manufacturerRepository.findById(Id);
    }*/


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

/*
    @Override
    public ProductManufacturer findManufacturerById(Long id) {

        Query q = entityManager.createNativeQuery("SELECT pm.id AS id,pm.product_manufacturer_name AS productManufacturerName,pm.product_manufacturer_created AS productManufacturerCreated FROM product_manufacturer pm","findManufacturerById");
        var query = "SELECT pm.id AS id,pm.product_manufacturer_name AS productManufacturerName,pm.product_manufacturer_created AS productManufacturerCreated FROM product_manufacturer pm";
        ProductManufacturer manufacturer = entityManager.createNativeQuery(query, "findManufacturerById").getSingleResult();

        if (manufacturer == null){
            throw new EntityNotFoundException("Manufacturer with ID " + id + "Was NOT found in the database");
        } else {
            return manufacturer;
        }

    }

*/



    //TODO add deleteManufacturerById
    //TODO Add method for updateManufacturerById
}
