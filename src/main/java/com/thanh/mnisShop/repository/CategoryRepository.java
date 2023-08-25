package com.thanh.mnisShop.repository;

import com.thanh.mnisShop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
