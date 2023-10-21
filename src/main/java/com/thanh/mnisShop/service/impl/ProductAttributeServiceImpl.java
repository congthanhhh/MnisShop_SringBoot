package com.thanh.mnisShop.service.impl;

import com.thanh.mnisShop.model.ProductAttribute;
import com.thanh.mnisShop.repository.ProductAttributeRepository;
import com.thanh.mnisShop.service.ProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {

    @Autowired
    ProductAttributeRepository productAttributeRepository;

    @Override
    public List<ProductAttribute> findProductAttributeByProductId(Long id) {
        return productAttributeRepository.findProductAttributeByProductId(id);
    }

    @Override
    public ProductAttribute findProductAndSizeById(Long productId, Long sizeId) {
        Optional<ProductAttribute> productOptional = productAttributeRepository.findProductAndSizeById(productId, sizeId);
        return productOptional.orElse(null);
    }
}
