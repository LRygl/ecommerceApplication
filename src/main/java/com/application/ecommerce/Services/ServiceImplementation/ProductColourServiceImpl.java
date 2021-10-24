package com.application.ecommerce.Services.ServiceImplementation;

import com.application.ecommerce.Model.ProductColour;
import com.application.ecommerce.Repository.ProductColourRepository;
import com.application.ecommerce.Services.ProductColourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProductColourServiceImpl implements ProductColourService {

    private final ProductColourRepository productColourRepository;
    private final ProductColour productColour;
    public ProductColourServiceImpl(ProductColourRepository productColourRepository, ProductColour productColour) {
        this.productColourRepository = productColourRepository;
        this.productColour = productColour;
    }

    @Autowired
    public List<ProductColour> getAllProductColours(){
        return productColourRepository.findAll();
}

    public ProductColour findProductColourById(Long id){
        return productColourRepository.findProductColourById(id);
    }

    public ProductColour addNewProductColour(ProductColour productColour){
        ProductColour newColour = new ProductColour();
        newColour.setProductColourName(productColour.getProductColourName());
        newColour.setProductColourCreated(new Date());
        newColour.setProductColourHex(productColour.getProductColourHex());
        newColour.setProductColourIsActive(true);
        productColourRepository.save(newColour);
        return newColour;
    }

    public void updateProductColour(Long id, ProductColour productColour){
        ProductColour updateProductColour = productColourRepository.findProductColourById(id);
        updateProductColour.setProductColourHex(productColour.getProductColourHex());
        updateProductColour.setProductColourName(productColour.getProductColourName());
        updateProductColour.setProductColourModified(new Date());
        updateProductColour.setProductColourIsActive(productColour.getProductColourIsActive());
        productColourRepository.save(updateProductColour);
    }

    public void deleteProductColourById(Long id){
        productColourRepository.deleteById(id);
    }
}
