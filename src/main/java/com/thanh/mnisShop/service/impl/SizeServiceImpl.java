package com.thanh.mnisShop.service.impl;

import com.thanh.mnisShop.model.Size;
import com.thanh.mnisShop.repository.SizeRepository;
import com.thanh.mnisShop.service.SizeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<Size> findAll() {
        return sizeRepository.findAll();
    }

    @Override
    public Optional<Size> findById(Long id) {
        return sizeRepository.findById(id);
    }

    @Override
    public Size create(Size size) {
        return sizeRepository.save(size);
    }

    @Override
    public Size update(Long id, Size size) {
        return sizeRepository.findById(id)
                .map(updatesize -> {
                    updatesize.setId(size.getId());
                    updatesize.setName(size.getName());
                    updatesize.setProductAttributes(size.getProductAttributes());
                    return sizeRepository.save(updatesize);
                })
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        Optional<Size> size = sizeRepository.findById(id);
        if (size.isPresent()) {
            sizeRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("size not found with id: " + id);
        }
    }
}
