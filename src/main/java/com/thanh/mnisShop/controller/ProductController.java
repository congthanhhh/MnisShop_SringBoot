package com.thanh.mnisShop.controller;

import com.thanh.mnisShop.model.Product;
import com.thanh.mnisShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/home")
    public String home(Model model) {
        List<Product> items = productService.findAll();
        model.addAttribute("items", items);
        return "home/product/homeProduct";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        Product items = productService.findById(id);
        model.addAttribute("detailPr", items);
        return "home/product/detailProduct";
    }

    @RequestMapping("/shop")
    public String shop(Model model) {
        List<Product> items = productService.findAll();
        model.addAttribute("items", items);
        return "home/product/shopProduct";
    }


}
