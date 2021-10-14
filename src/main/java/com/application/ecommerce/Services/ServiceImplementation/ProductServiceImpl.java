package com.application.ecommerce.Services.ServiceImplementation;

import com.application.ecommerce.Model.Product;
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

    @Autowired
    public  ProductServiceImpl(ProductRepository productRepository){
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


    @Override
    public Product addNewProduct(String productName, String productNumber ){
        Product product = new Product();
        product.setProductName(productName);
        product.setProductNumber(productNumber);
        product.setProductCreated(new Date());
        productRepository.save(product);
        return product;
    }

    @Override
    public Product findByProductName(String productName){
        return productRepository.findByProductName(productName);
    }

}
