package com.thanh.mnisShop.service.impl;

import com.thanh.mnisShop.model.ProductImage;
import com.thanh.mnisShop.repository.ProductImageRepository;
import com.thanh.mnisShop.service.ProductImageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public List<ProductImage> findAll() {
        return productImageRepository.findAll();
    }

    @Override
    public Optional<ProductImage> findById(Long id) {
        return productImageRepository.findById(id);
    }

    @Override
    public List<ProductImage> findImageByProductId(Long id) {
        return productImageRepository.findImageByProductId(id);
    }

    @Override
    public ProductImage create(ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

    @Override
    public ProductImage update(Long id, ProductImage productImage) {
        return productImageRepository.findById(id)
                .map(updateProductImage -> {
                    updateProductImage.setId(productImage.getId());
                    updateProductImage.setImage(productImage.getImage());
                    updateProductImage.setProduct(productImage.getProduct());
                    return productImageRepository.save(updateProductImage);
                })
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        Optional<ProductImage> productImage = productImageRepository.findById(id);
        if (productImage.isPresent()) {
            productImageRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Product image not found with id: " + id);
        }
    }
}
