package com.thanh.mnisShop.controller;

import com.thanh.mnisShop.dto.CategoryAmountProductDTO;
import com.thanh.mnisShop.model.Product;
import com.thanh.mnisShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/home")
    public String home(Model model) {
        List<Product> items = productService.findAll();
        model.addAttribute("items", items);

        /*Số lượng products của từng category*/
//        List<CategoryAmountProductDTO> itemsCate = productService.findAmountProductsOfCategory();
//        model.addAttribute("itemsCate", itemsCate);
        return "home/product/homeProduct";
    }

//    @RequestMapping("/detail/{id}")
//    public String detail(@PathVariable("id") Long id, Model model) {
//        Product items = productService.findById(id);
//        model.addAttribute("detailPr", items);
//        return "home/product/detailProduct";
//    }

//    @RequestMapping("/shop")
//    public String shop(Model model, @RequestParam("cid")Optional<String> cid,
//                       @RequestParam("page") Optional<Integer> page) {
//        Pageable pageable = PageRequest.of(page.orElse(0),9);
//        Page<Product> items;
//        /* Show product neu chon category */
//        if (cid.isPresent()) {
//            items = productService.findByCategoryIdPage(cid.get(),pageable);
//        } else {
//            items = productService.findAllPage(pageable);
//        }
//        model.addAttribute("items", items);
//        return "home/product/shopProduct";
//    }


}
