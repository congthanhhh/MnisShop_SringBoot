package com.thanh.mnisShop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Orderdetails")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Orderid", referencedColumnName = "Id")
    @JsonIgnoreProperties(value = {"applications","hibernateLazyInitializer"})
    private Order order;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Productid", referencedColumnName = "Id")
    @JsonIgnoreProperties(value = {"applications","hibernateLazyInitializer"})
    private Product product;

    private Double price;
    private Integer quantity;
}
