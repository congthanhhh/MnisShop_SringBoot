package com.thanh.mnisShop.repository;

import com.thanh.mnisShop.dto.CategoryAmountProductDTO;
import com.thanh.mnisShop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.category.id = ?1")
    List<Product> findByCategoryId(String cid);

    @Query("SELECT p FROM Product p WHERE p.category.id = ?1")
    Page<Product> findByCategoryIdPage(String cid, Pageable pageable);


    @Query("SELECT new com.thanh.mnisShop.dto.CategoryAmountProductDTO(p.category, COUNT(p.id)) FROM Product p GROUP BY p.category")
    List<CategoryAmountProductDTO> findAmountProductsOfCategory();

}
