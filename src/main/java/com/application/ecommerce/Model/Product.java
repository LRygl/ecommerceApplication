package com.application.ecommerce.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "productCategory_id")
    private ProductCategory productCategory;

    private String productName;
    private Date productCreated;

    public Product() {
    }

    public Product(Long id, ProductCategory productCategory, String productName, Date productCreated) {
        this.id = id;
        this.productCategory = productCategory;
        this.productName = productName;
        this.productCreated = productCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getProductCreated() {
        return productCreated;
    }

    public void setProductCreated(Date productCreated) {
        this.productCreated = productCreated;
    }
}
