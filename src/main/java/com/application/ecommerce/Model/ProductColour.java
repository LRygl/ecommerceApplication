package com.application.ecommerce.Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product_colour")
@Component
public class ProductColour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productColourName;
    private String productColourHex;
    private Date productColourCreated;
    private Date productColourModified;
    private Boolean productColourIsActive;

    public ProductColour() {
    }

    public ProductColour(Long id, String productColourName, String productColourHex, Date productColourCreated, Date productColourModified, Boolean productColourIsActive) {
        this.id = id;
        this.productColourName = productColourName;
        this.productColourHex = productColourHex;
        this.productColourCreated = productColourCreated;
        this.productColourModified = productColourModified;
        this.productColourIsActive = productColourIsActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductColourName() {
        return productColourName;
    }

    public void setProductColourName(String productColourName) {
        this.productColourName = productColourName;
    }

    public String getProductColourHex() {
        return productColourHex;
    }

    public void setProductColourHex(String productColourHex) {
        this.productColourHex = productColourHex;
    }

    public Date getProductColourCreated() {
        return productColourCreated;
    }

    public void setProductColourCreated(Date productColourCreated) {
        this.productColourCreated = productColourCreated;
    }

    public Date getProductColourModified() {
        return productColourModified;
    }

    public void setProductColourModified(Date productColourModified) {
        this.productColourModified = productColourModified;
    }

    public Boolean getProductColourIsActive() {
        return productColourIsActive;
    }

    public void setProductColourIsActive(Boolean productColourIsActive) {
        this.productColourIsActive = productColourIsActive;
    }

    @Override
    public String toString() {
        return "ProductColour{" +
                "id=" + id +
                ", productColourName='" + productColourName + '\'' +
                ", productColourHex='" + productColourHex + '\'' +
                ", productColourCreated=" + productColourCreated +
                ", productColourModified=" + productColourModified +
                ", productColourIsActive=" + productColourIsActive +
                '}';
    }
}
