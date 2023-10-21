package com.thanh.mnisShop.service.impl;

import com.thanh.mnisShop.model.Authority;
import com.thanh.mnisShop.repository.AuthorityRepository;
import com.thanh.mnisShop.service.AuthorityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public List<Authority> findAuthoritiesOfAdministrator() {
        return null;
    }

    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }

    @Override
    public Authority create(Authority auth) {
        return authorityRepository.save(auth);
    }

    @Override
    public void delete(Long id) {
        Optional<Authority> authority = authorityRepository.findById(id);
        if (authority.isPresent()) {
            authorityRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Category not found with id: " + id);
        }
    }
}
