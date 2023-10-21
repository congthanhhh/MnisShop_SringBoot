package com.thanh.mnisShop.controller;

import com.thanh.mnisShop.dto.CategoryAmountProductDTO;
import com.thanh.mnisShop.model.*;
import com.thanh.mnisShop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductImageService productImageService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private SizeService sizeService;

    @Autowired
    private ProductAttributeService productAttributeService;

    @RequestMapping("/home")
    public String home(Model model) {
        List<Product> items = productService.findAll();
        model.addAttribute("items", items);

        /*Số lượng products của từng category*/
        List<CategoryAmountProductDTO> itemsCate = productService.findAmountProductsOfCategory();
        model.addAttribute("itemsCate", itemsCate);
        return "home/product/homeProduct";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        Product items = productService.findById(id);
        List<ProductImage> productImage = productImageService.findImageByProductId(id);
        List<ProductAttribute> productAttributes = productAttributeService.findProductAttributeByProductId(id);

        model.addAttribute("detailPr", items);
        model.addAttribute("imgPr", productImage);
        model.addAttribute("attributePr", productAttributes);

        return "home/product/detailProduct";
    }


    @RequestMapping("/shop")
    public String shop(Model model, @RequestParam("cid")Optional<String> cid,
                       @RequestParam("page") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0),9);
        Page<Product> items;
        /* Show product neu chon category */
        if (cid.isPresent()) {
            items = productService.findByCategoryIdPage(cid.get(),pageable);
        } else {
            items = productService.findAllPage(pageable);
        }
        model.addAttribute("items", items);
        model.addAttribute("cid", cid.orElse(null));
        return "home/product/shopProduct";
    }

    @ModelAttribute("productAttr")
    public List<ProductAttribute> getProductAttribute(Long id) {
        return productAttributeService.findProductAttributeByProductId(id);
    }

    @ModelAttribute("productImage")
    public List<ProductImage> getProductImage() {
        return productImageService.findAll();
    }

    @ModelAttribute("productSize")
    public List<Size> getProductSize() {
        return sizeService.findAll();
    }

    @ModelAttribute("productColor")
    public List<Color> getProductColor() {
        return colorService.findAll();
    }



}
