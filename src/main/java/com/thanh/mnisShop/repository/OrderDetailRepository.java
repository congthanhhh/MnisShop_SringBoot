package com.thanh.mnisShop.repository;

import com.thanh.mnisShop.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    @Query("SELECT p FROM OrderDetail p where p.order.id = ?1")
    List<OrderDetail> findByOrderId(Long id);
}
