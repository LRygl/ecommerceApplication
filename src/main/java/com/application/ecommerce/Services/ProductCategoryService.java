package com.application.ecommerce.Services;

import com.application.ecommerce.Model.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    public List<ProductCategory> getAllProductCategories();

    ProductCategory findProductCategoryById(Long id);
}
