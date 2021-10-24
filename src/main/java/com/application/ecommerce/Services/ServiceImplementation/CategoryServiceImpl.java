package com.application.ecommerce.Services.ServiceImplementation;

import com.application.ecommerce.Model.ProductCategory;
import com.application.ecommerce.Model.ProductColour;
import com.application.ecommerce.Repository.ProductCategoryRepository;
import com.application.ecommerce.Services.ProductCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
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
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory findProductCategoryById(Long id) {
        return productCategoryRepository.findProductCategoryById(id);
    }

    public ProductCategory addNewProductCategory(ProductCategory productCategory){
        ProductCategory newCategory = new ProductCategory();
        newCategory.setCategoryName(productCategory.getCategoryName());
        newCategory.setCategoryCreated(new Date());
        newCategory.setCategoryActive(true);
        productCategoryRepository.save(newCategory);
        return newCategory;
    }

    public void updateProductCategoryById(Long id, ProductCategory productCategory){
        ProductCategory updateProductCategory = productCategoryRepository.findProductCategoryById(id);
        updateProductCategory.setCategoryActive(productCategory.getCategoryActive());
        updateProductCategory.setCategoryName(productCategory.getCategoryName());
        updateProductCategory.setCategoryModified(new Date());
        productCategoryRepository.save(updateProductCategory);
    }

    public void deleteProductCategoryById(Long id){
        productCategoryRepository.deleteById(id);
    }


}
