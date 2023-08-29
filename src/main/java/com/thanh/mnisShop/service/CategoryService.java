package com.thanh.mnisShop.service;

import com.thanh.mnisShop.dto.CategoryAmountProductDTO;
import com.thanh.mnisShop.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();

    Optional<Category> findById(String id);

    Category create(Category category);

    Category update(String id, Category category);

    void delete(String id);

}
