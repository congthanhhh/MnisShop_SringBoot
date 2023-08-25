package com.thanh.mnisShop.service.impl;

import com.thanh.mnisShop.model.Product;
import com.thanh.mnisShop.repository.ProductRepository;
import com.thanh.mnisShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElse(null);
    }

//    @Override
//    public List<Product> findByCategoryId(String cid) {
//        return null;
//    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Integer id, Product product) {
        return productRepository.findById(id)
                .map(updateProduct -> {
                    updateProduct.setName(product.getName());
                    updateProduct.setImage(product.getImage());
                    updateProduct.setPrice(product.getPrice());
                    updateProduct.setCreateDate(product.getCreateDate());
                    updateProduct.setAvailable(product.getAvailable());
                    updateProduct.setCategory(product.getCategory());
                    return productRepository.save(updateProduct);
                })
                .orElse(null);
    }

    @Override
//    public void delete(Integer id) {
//        if (productRepository.existsById(id)) {
//            productRepository.deleteById(id);
//        }
//    }
    public void delete(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException();
        }
    }


}
