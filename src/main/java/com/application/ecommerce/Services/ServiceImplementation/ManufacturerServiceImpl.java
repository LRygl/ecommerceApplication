package com.application.ecommerce.Services.ServiceImplementation;

import com.application.ecommerce.Model.ProductManufacturer;
import com.application.ecommerce.Repository.ManufacturerRepository;
import com.application.ecommerce.Services.ManufacturerService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService {

    private ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<ProductManufacturer> getAllManufacturers() {return manufacturerRepository.findAll();}

    @Transactional
    public Optional<ProductManufacturer> findById(Long Id){
        Optional<ProductManufacturer> productManufacturer = manufacturerRepository.findById(Id);
        return productManufacturer;
    }

    @Override
    public ProductManufacturer addNewManufacturer(String manufacturerName){
        ProductManufacturer productManufacturer = new ProductManufacturer();
        productManufacturer.setProductManufacturerName(manufacturerName);
        productManufacturer.setProductManufacturerCreated(new Date());
        manufacturerRepository.save(productManufacturer);
        return productManufacturer;
    }


    //TODO add deleteManufacturerById


    //TODO Add method for updateManufacturerById



}
