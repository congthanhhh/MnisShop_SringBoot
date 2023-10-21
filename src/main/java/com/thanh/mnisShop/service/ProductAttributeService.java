package com.thanh.mnisShop.service;

import com.thanh.mnisShop.model.ProductAttribute;

import java.util.List;

public interface ProductAttributeService {
    List<ProductAttribute> findProductAttributeByProductId(Long id);

    ProductAttribute findProductAndSizeById(Long productId, Long sizeId);
}
