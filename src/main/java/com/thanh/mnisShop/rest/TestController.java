package com.thanh.mnisShop.rest;

import com.thanh.mnisShop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
//@Controller
public class TestController {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @RequestMapping("rest/index")
    public Map<String, Object> getData() {
        Map<String, Object> data = new HashMap<>();
        data.put("categories", categoryRepository.findAll());
        data.put("orders", orderRepository.findAll());
        data.put("orderDetails", orderDetailRepository.findAll());
        data.put("products", productRepository.findAll());
        data.put("authorities", authorityRepository.findAll());
        data.put("accounts", accountRepository.findAll());
        data.put("roles", roleRepository.findAll());
        return data;
    }
}
