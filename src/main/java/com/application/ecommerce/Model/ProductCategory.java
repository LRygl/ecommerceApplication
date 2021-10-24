package com.application.ecommerce.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="product_category")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String CategoryName;
    private Date CategoryCreated;
    private Date CategoryModified;
    private Boolean isCategoryActive;

    public ProductCategory() {
    }

    public ProductCategory(Long id, String categoryName, Date categoryCreated, Date categoryModified, Boolean isCategoryActive) {
        this.id = id;
        CategoryName = categoryName;
        CategoryCreated = categoryCreated;
        CategoryModified = categoryModified;
        this.isCategoryActive = isCategoryActive;
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

    public Date getCategoryCreated() {
        return CategoryCreated;
    }

    public void setCategoryCreated(Date categoryCreated) {
        CategoryCreated = categoryCreated;
    }

    public Date getCategoryModified() {
        return CategoryModified;
    }

    public void setCategoryModified(Date categoryModified) {
        CategoryModified = categoryModified;
    }

    public Boolean getCategoryActive() {
        return isCategoryActive;
    }

    public void setCategoryActive(Boolean categoryActive) {
        isCategoryActive = categoryActive;
    }
}
