package com.thanh.mnisShop.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.thanh.mnisShop.model.Order;

import java.util.List;

public interface OrderService {
    Order create(JsonNode orderData);

    List<Order> findAll();

    Order findById(Long id);

    List<Order> findByUsername(String username);
}
