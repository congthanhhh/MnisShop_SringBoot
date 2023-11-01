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
    public List<ProductAttribute> findAll() {
        return productAttributeRepository.findAll();
    }

    @Override
    public List<ProductAttribute> findProductAttributeByProductId(Long id) {
        return productAttributeRepository.findProductAttributeByProductId(id);
    }
    @Override
    public Optional<ProductAttribute> findById(Long id) {
        return productAttributeRepository.findById(id);
    }
    @Override
    public ProductAttribute findProductSizeAndColorById(Long productId, Long colorId, Long sizeId) {
        Optional<ProductAttribute> productOptional = productAttributeRepository.findProductSizeAndColorById(productId, colorId, sizeId);
        return productOptional.orElse(null);
    }

    @Override
    public void updateStockById(Long quantity,Long productId, Long colorId, Long sizeId) {
        productAttributeRepository.updateStockById(quantity, productId, colorId, sizeId);
    }
}
