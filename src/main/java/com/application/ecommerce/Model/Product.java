package com.application.ecommerce.Model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name="Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String productName;
    private String productImageUrl;
    private String productNumber;
    @ManyToOne
    @JoinColumn(name = "product_colour_id")
    private ProductColour productColour;
    @ManyToOne
    @JoinColumn(name = "product_manufacturer_id")
    private ProductManufacturer productManufacturer;
    private Integer productQuantity;
    @CreationTimestamp
    private Date productCreated;
    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

    public Product() {
    }

    public Product(Long id, String productName, String productImageUrl, String productNumber, ProductColour productColour, ProductManufacturer productManufacturer, Integer productQuantity, Date productCreated, ProductCategory productCategory) {
        this.id = id;
        this.productName = productName;
        this.productImageUrl = productImageUrl;
        this.productNumber = productNumber;
        this.productColour = productColour;
        this.productManufacturer = productManufacturer;
        this.productQuantity = productQuantity;
        this.productCreated = productCreated;
        this.productCategory = productCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public ProductColour getProductColour() {
        return productColour;
    }

    public void setProductColour(ProductColour productColour) {
        this.productColour = productColour;
    }

    public ProductManufacturer getProductManufacturer() { return productManufacturer; }

    public void setProductManufacturer(ProductManufacturer productManufacturer) { this.productManufacturer = productManufacturer; }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Date getProductCreated() {
        return productCreated;
    }

    public void setProductCreated(Date productCreated) {
        this.productCreated = productCreated;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
