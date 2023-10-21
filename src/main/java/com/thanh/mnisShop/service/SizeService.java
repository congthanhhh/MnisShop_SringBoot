package com.thanh.mnisShop.service;

import com.thanh.mnisShop.model.Size;

import java.util.List;
import java.util.Optional;

public interface SizeService {
    List<Size> findAll();

    Optional<Size> findById(Long id);

    Size create(Size size);

    Size update(Long id, Size size);

    void delete(Long id);
}
