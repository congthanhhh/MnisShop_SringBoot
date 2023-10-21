package com.thanh.mnisShop.service;

import com.thanh.mnisShop.model.Authority;

import java.util.List;

public interface AuthorityService {

    List<Authority> findAuthoritiesOfAdministrator();

    List<Authority> findAll();

    Authority create(Authority auth);

    void delete(Long id);
}
