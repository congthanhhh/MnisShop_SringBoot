package com.thanh.mnisShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/home")
    public String home() {

        return "home/product/homeProduct";
    }

    @RequestMapping("/detail")
    public String detail() {

        return "home/product/detailProduct";
    }

    @RequestMapping("/shop")
    public String shop() {

        return "home/product/shopProduct";
    }


}
