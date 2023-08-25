package com.thanh.mnisShop.service;

import com.thanh.mnisShop.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Integer id);

//    List<Product> findByCategoryId(String cid);

    Product create(Product product);

    Product update(Integer id, Product product);

    void delete(Integer id);


}
