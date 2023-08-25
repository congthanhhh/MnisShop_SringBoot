package com.thanh.mnisShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

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
}
