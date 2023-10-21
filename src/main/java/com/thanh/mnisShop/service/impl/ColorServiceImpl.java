package com.thanh.mnisShop.service.impl;

import com.thanh.mnisShop.model.Color;
import com.thanh.mnisShop.repository.ColorRepository;
import com.thanh.mnisShop.service.ColorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<Color> findAll() {
        return colorRepository.findAll();
    }

    @Override
    public Optional<Color> findById(Long id) {
        return colorRepository.findById(id);
    }

    @Override
    public Color create(Color color) {
        return colorRepository.save(color);
    }

    @Override
    public Color update(Long id, Color color) {
        return colorRepository.findById(id)
                .map(updatecolor -> {
                    updatecolor.setId(color.getId());
                    updatecolor.setName(color.getName());
                    updatecolor.setProductAttributes(color.getProductAttributes());
                    return colorRepository.save(updatecolor);
                })
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        Optional<Color> color = colorRepository.findById(id);
        if (color.isPresent()) {
            colorRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Color not found with id: " + id);
        }
    }
}
