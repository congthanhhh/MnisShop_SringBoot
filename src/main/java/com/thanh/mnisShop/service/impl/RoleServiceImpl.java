package com.thanh.mnisShop.service.impl;

import com.thanh.mnisShop.model.Role;
import com.thanh.mnisShop.repository.RoleRepository;
import com.thanh.mnisShop.service.RoleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(String id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(String id, Role role) {
        return roleRepository.findById(id)
                .map(updateRole -> {
                    updateRole.setId(role.getId());
                    updateRole.setName(role.getName());
                    updateRole.setAuthorities(role.getAuthorities());
                    return roleRepository.save(updateRole);
                })
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent()) {
            roleRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Role not found with id: " + id);
        }
    }
}
