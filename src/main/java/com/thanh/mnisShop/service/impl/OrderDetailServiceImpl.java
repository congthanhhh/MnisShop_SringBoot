package com.thanh.mnisShop.service.impl;

import com.thanh.mnisShop.model.OrderDetail;
import com.thanh.mnisShop.repository.OrderDetailRepository;
import com.thanh.mnisShop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> findByOrderId(Long id) {
        return orderDetailRepository.findByOrderId(id);
    }
}
