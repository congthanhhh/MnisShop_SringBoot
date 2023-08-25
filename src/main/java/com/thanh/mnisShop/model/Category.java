package com.thanh.mnisShop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Categories")
public class Category {
    @Id
    private String id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    List<Product> products;
}