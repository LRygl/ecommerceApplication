package com.application.ecommerce.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="product_category")
public class ProductCategory {

    private Long id;
    private String CategoryName;
    private Date CategoryNameAdded;

    public ProductCategory() {
    }

    public ProductCategory(Long id, String categoryName, Date categoryNameAdded) {
        this.id = id;
        CategoryName = categoryName;
        CategoryNameAdded = categoryNameAdded;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public Date getCategoryNameAdded() {
        return CategoryNameAdded;
    }

    public void setCategoryNameAdded(Date categoryNameAdded) {
        CategoryNameAdded = categoryNameAdded;
    }
}
