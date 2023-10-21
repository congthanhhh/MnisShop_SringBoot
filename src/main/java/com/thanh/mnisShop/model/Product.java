package com.thanh.mnisShop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String thumbnail;
    private Double price;

    @Column(name = "create_date")
    @CreationTimestamp
    private Timestamp createDate;

    private Boolean available;
    private String description;
    private Long quantity;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"applications","hibernateLazyInitializer"})
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<ProductImage> productImages;

    @JsonIgnore
    @OneToMany(mappedBy = "product",  fetch = FetchType.EAGER)
    List<ProductAttribute> productAttributes;

}
