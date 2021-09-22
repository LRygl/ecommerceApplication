package com.application.ecommerce.Services.ServiceImplementation;

import com.application.ecommerce.Model.Product;
import com.application.ecommerce.Repository.ProductRepository;
import com.application.ecommerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

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
    public List<Product> getAllProducts() {return productRepository.findAll();}

    @Override
    public Product addNewProduct(String productName){
        Product product = new Product();
        product.setProductName(productName);
        product.setProductCreated(new Date());
        productRepository.save(product);
        return product;
    }

}
