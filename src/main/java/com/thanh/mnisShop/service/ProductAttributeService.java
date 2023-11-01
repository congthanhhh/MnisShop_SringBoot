package com.thanh.mnisShop.service;

import com.thanh.mnisShop.model.ProductAttribute;

import java.util.List;
import java.util.Optional;

public interface ProductAttributeService {
    List<ProductAttribute> findAll();

    List<ProductAttribute> findProductAttributeByProductId(Long id);


    Optional<ProductAttribute> findById(Long id);

    ProductAttribute findProductSizeAndColorById(Long productId, Long colorId, Long sizeId);

    void updateStockById(Long quantity, Long productId, Long colorId, Long sizeId);
}
