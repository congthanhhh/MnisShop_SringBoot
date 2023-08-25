package com.thanh.mnisShop.service.impl;

import com.thanh.mnisShop.model.Category;
import com.thanh.mnisShop.repository.CategoryRepository;
import com.thanh.mnisShop.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(String id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(String id, Category category) {
        return categoryRepository.findById(id)
                .map(updateCategory -> {
                    updateCategory.setId(category.getId());
                    updateCategory.setName(category.getName());
                    updateCategory.setProducts(category.getProducts());
                    return categoryRepository.save(updateCategory);
                })
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Category not found with id: " + id);
        }
    }
}
