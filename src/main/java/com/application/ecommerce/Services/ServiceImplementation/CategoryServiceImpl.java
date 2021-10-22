package com.application.ecommerce.Services.ServiceImplementation;

import com.application.ecommerce.Model.ProductCategory;
import com.application.ecommerce.Repository.ProductCategoryRepository;
import com.application.ecommerce.Services.ProductCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements ProductCategoryService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private ProductCategoryRepository productCategoryRepository;

    public CategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public List<ProductCategory> getAllProductCategories() {
        List<ProductCategory> list = productCategoryRepository.findAll();
        logger.info("Returning list of Product Categories. " + list.size() + " items were found");
    return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory findProductCategoryById(Long id) {
        return null;
    }


}
