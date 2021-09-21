package com.application.ecommerce.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="product_manufacturer")
public class ProductManufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productManufacturerName;
    private Date productManufacturerCreated;

    public ProductManufacturer() {
    }

    public ProductManufacturer(Long id, String productManufacturerName, Date productManufacturerCreated) {
        this.id = id;
        this.productManufacturerName = productManufacturerName;
        this.productManufacturerCreated = productManufacturerCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductManufacturerName() {
        return productManufacturerName;
    }

    public void setProductManufacturerName(String productManufacturerName) {
        this.productManufacturerName = productManufacturerName;
    }

    public Date getProductManufacturerCreated() {
        return productManufacturerCreated;
    }

    public void setProductManufacturerCreated(Date productManufacturerCreated) {
        this.productManufacturerCreated = productManufacturerCreated;
    }
}
