package com.thanh.mnisShop.service;

import com.thanh.mnisShop.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> findAll();

    Role findById(String id);

    Role create(Role role);

    Role update(String id, Role role);

    void delete(String id);
}
