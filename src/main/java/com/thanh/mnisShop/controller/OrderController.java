package com.thanh.mnisShop.controller;

import com.thanh.mnisShop.service.OrderDetailService;
import com.thanh.mnisShop.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService;


    @RequestMapping("/")
    public String order() {

        return "home/order/myOrder";
    }

    @RequestMapping("/detail")
    public String orderDetail() {

        return "home/order/orderDetail";
    }

    @RequestMapping("/checkout")
    public String checkout() {

        return "home/order/checkout";
    }

    @RequestMapping("/checkoutDetail")
    public String checkoutDetail() {

        return "home/order/checkoutDetail";
    }

    @RequestMapping("/list")
    public String orderList(Model model, HttpServletRequest request) {
        return "home/order/checkoutDetail";
    }

    @RequestMapping("/detail/{id}")
    public String orderDetail(@PathVariable("id") Long id, Model model) {
        model.addAttribute("orderDetail", orderDetailService.findByOrderId(id));
        return "home/order/orderDetail";
    }
}
