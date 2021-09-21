package com.application.ecommerce.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product_colour")
public class ProductColour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productColourName;
    private Date productColourCreated;

    public ProductColour(Long id, String productColourName, Date productColourCreated) {
        this.id = id;
        this.productColourName = productColourName;
        this.productColourCreated = productColourCreated;
    }

    public ProductColour() {
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

    public Date getProductColourCreated() {
        return productColourCreated;
    }

    public void setProductColourCreated(Date productColourCreated) {
        this.productColourCreated = productColourCreated;
    }
}
