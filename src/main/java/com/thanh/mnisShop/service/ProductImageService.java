package com.thanh.mnisShop.service;

import com.thanh.mnisShop.model.ProductImage;

import java.util.List;
import java.util.Optional;

public interface ProductImageService {
    List<ProductImage> findAll();

    Optional<ProductImage> findById(Long id);

    List<ProductImage> findImageByProductId(Long id);

    ProductImage create(ProductImage productImage);

    ProductImage update(Long id, ProductImage productImage);

    void delete(Long id);
}
