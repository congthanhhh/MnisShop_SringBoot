package com.thanh.mnisShop.repository;

import com.thanh.mnisShop.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
