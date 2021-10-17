package com.application.ecommerce.Resources;

import com.application.ecommerce.Services.ProductCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class ProductCategoryResource {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private ProductCategoryService productCategoryService;

}
