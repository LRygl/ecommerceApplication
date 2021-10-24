package com.application.ecommerce.Services;

import com.application.ecommerce.Model.Product;
import com.application.ecommerce.Model.ProductColour;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;


public interface ProductColourService {
    List<ProductColour> getAllProductColours();

    ProductColour addNewProductColour(ProductColour productColour);
    ProductColour findProductColourById(Long id);

    void deleteProductColourById(Long id);
    void updateProductColour(Long id, ProductColour productColour);
}
