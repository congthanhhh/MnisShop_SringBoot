package com.thanh.mnisShop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String image;
    private Double price;

    @Column(name = "Createdate")
    @CreationTimestamp
    private Timestamp createDate;

    private Boolean available;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Categoryid", referencedColumnName = "Id")
    @JsonIgnoreProperties(value = {"applications","hibernateLazyInitializer"})
    private Category category;

//    @ManyToOne
//    @JoinColumn(name = "Categoryid")
//    Category category;
}
