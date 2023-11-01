package com.thanh.mnisShop.service;

import com.thanh.mnisShop.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> findByOrderId(Long id);
}
