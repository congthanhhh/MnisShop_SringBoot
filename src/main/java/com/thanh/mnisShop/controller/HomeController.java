package com.thanh.mnisShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("home/index")
    public String product() {

        return "home/product/homeProduct";
    }
}
