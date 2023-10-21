package com.thanh.mnisShop.repository;

import com.thanh.mnisShop.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    @Query("SELECT p FROM ProductImage p WHERE p.product.id = ?1")
    List<ProductImage> findImageByProductId(Long id);
}
