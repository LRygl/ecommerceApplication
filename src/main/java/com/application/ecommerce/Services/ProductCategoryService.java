package com.application.ecommerce.Services;

import com.application.ecommerce.Model.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> getAllProductCategories();

    ProductCategory findProductCategoryById(Long id);

    ProductCategory addNewProductCategory(ProductCategory productCategory);
    void updateProductCategoryById(Long id, ProductCategory productCategory);
    void deleteProductCategoryById(Long id);
}
