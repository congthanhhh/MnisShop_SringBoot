package com.thanh.mnisShop.repository;

import com.thanh.mnisShop.model.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long> {

    @Query("SELECT p FROM ProductAttribute p WHERE p.product.id = ?1")
    List<ProductAttribute> findProductAttributeByProductId(Long id);

    @Query("SELECT p FROM ProductAttribute p WHERE p.product.id = ?1 AND p.sizes.id = ?2")
    List<ProductAttribute> findProductAttributeByProductId(Long productId, Long sizeId);

    @Query("SELECT p FROM ProductAttribute p WHERE p.product.id = ?1 and p.colors.id = ?2 and p.sizes.id = ?3")
    Optional<ProductAttribute> findProductSizeAndColorById(Long productId, Long colorId, Long sizeId);

    @Modifying
    @Transactional
    @Query("UPDATE ProductAttribute p SET p.stock = p.stock - :quantity " +
            "WHERE p.product.id = :productId AND p.colors.id = :colorId AND p.sizes.id = :sizeId AND p.stock >= :quantity")
    void updateStockById(@Param("quantity") Long quantity,
                         @Param("productId") Long productId,
                         @Param("colorId") Long colorId,
                         @Param("sizeId") Long sizeId);



}
