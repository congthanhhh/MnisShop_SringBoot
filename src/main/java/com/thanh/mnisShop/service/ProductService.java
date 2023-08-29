package com.thanh.mnisShop.service;

import com.thanh.mnisShop.dto.CategoryAmountProductDTO;
import com.thanh.mnisShop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Page<Product> findAllPage(Pageable pageable);
    List<Product> findAll();

    Product findById(Integer id);

    List<Product> findByCategoryId(String cid);
    Page<Product> findByCategoryIdPage(String cid, Pageable pageable);

    Product create(Product product);

    Product update(Integer id, Product product);

    void delete(Integer id);


    List<CategoryAmountProductDTO> findAmountProductsOfCategory();
}
