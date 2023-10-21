package com.thanh.mnisShop.repository;

import com.thanh.mnisShop.model.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long> {

    @Query("SELECT p FROM ProductAttribute p WHERE p.product.id = ?1")
    List<ProductAttribute> findProductAttributeByProductId(Long id);

    @Query("SELECT p FROM ProductAttribute p WHERE p.product.id = ?1 and p.colors.id = ?2")
    Optional<ProductAttribute> findProductAndSizeById(Long productId, Long colorId);

}
