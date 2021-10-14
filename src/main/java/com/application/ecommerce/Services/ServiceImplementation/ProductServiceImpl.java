package com.application.ecommerce.Services.ServiceImplementation;

import com.application.ecommerce.Model.Product;
import com.application.ecommerce.Model.ProductManufacturer;
import com.application.ecommerce.Model.Requests.ProductRequest;
import com.application.ecommerce.Repository.ManufacturerRepository;
import com.application.ecommerce.Repository.ProductRepository;
import com.application.ecommerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Qualifier("ProductDetailService")
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ManufacturerRepository manufacturerRepository;
    private ProductRequest productRequest;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ManufacturerRepository manufacturerRepository, ProductRequest productRequest) {
        this.manufacturerRepository = manufacturerRepository;
        this.productRequest = productRequest;
        this.productRepository = productRepository;
    }





    @Override
    public List<Product> getAllProducts(int limit) {return productRepository.findAll(PageRequest.of(0,limit)).toList();}

    @Transactional
    public Optional<Product> findById(Long Id){
        Optional<Product> product = productRepository.findById(Id);
        return product;
    }

    @Override
    public void deleteProduct(Long Id){
        productRepository.deleteById(Id);
    }

//This works but the format of the incomming data is not pretty

/*    @Override
    public Product addNewProduct(Product newProduct){
        var test = newProduct.getId();
*//*        Product product = new Product(newProduct);
        product.setProductName(productName);
        product.setProductNumber(productNumber);
        product.setProductCreated(new Date());*//*
        Product addedProduct = new Product();
        addedProduct.setProductName(newProduct.getProductName());
        addedProduct.setProductCreated(new Date());
        addedProduct.setProductManufacturer(newProduct.getProductManufacturer());


        productRepository.save(newProduct);
        return newProduct;
    }*/

    @Override
    public Product addNewProduct(ProductRequest productRequest){
        ProductManufacturer manufacturer = manufacturerRepository.findById(productRequest.manufacturerId);
        return null;
    }

    @Override
    public Product findByProductName(String productName){
        return productRepository.findByProductName(productName);
    }

}
