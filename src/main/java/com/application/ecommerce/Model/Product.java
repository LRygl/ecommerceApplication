package com.application.ecommerce.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private Date productCreated;







}
