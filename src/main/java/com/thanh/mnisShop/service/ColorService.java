package com.thanh.mnisShop.service;

import com.thanh.mnisShop.model.Color;

import java.util.List;
import java.util.Optional;

public interface ColorService {
    List<Color> findAll();

    Optional<Color> findById(Long id);

    Color create(Color color);

    Color update(Long id, Color color);

    void delete(Long id);
}
