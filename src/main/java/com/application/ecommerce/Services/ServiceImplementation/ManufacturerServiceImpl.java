package com.application.ecommerce.Services.ServiceImplementation;

import com.application.ecommerce.Model.ProductManufacturer;
import com.application.ecommerce.Repository.ManufacturerRepository;
import com.application.ecommerce.Services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService {

    private ManufacturerRepository manufacturerRepository;
    private final EntityManager entityManager;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository, EntityManager entityManager) {
        this.manufacturerRepository = manufacturerRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<ProductManufacturer> getAllManufacturers() {return manufacturerRepository.findAll();}

 /*   @Override
    public ProductManufacturer findById(Long Id){
        ProductManufacturer productManufacturer = manufacturerRepository.findById(Id);
        return productManufacturer;
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

        final String query;
        query = "SELECT pm.id AS id,pm.product_manufacturer_name AS productManufacturerName,pm.product_manufacturer_created AS productManufacturerCreated FROM product_manufacturer pm WHERE id = 1";
        ProductManufacturer manufacturer = (ProductManufacturer) entityManager.createNativeQuery(query, "ManufacturerSqlResultSetMapping").setParameter("id", 1).getSingleResult();

        return manufacturer;
    }
    //TODO add deleteManufacturerById
    //TODO Add method for updateManufacturerById
}
