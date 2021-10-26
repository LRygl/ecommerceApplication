package com.application.ecommerce.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product_stock_transaction")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stock_id;
    //FOREIGN KEY TO PRODUCT - ONA PRODUCT HAS MANY RECORDS
    private Long product_id;
    private Integer stock_quantity;
    private Integer stock_current_quantity;
    private String stock_operation;
    private Date stock_record_date;

}
