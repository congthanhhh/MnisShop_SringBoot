package com.thanh.mnisShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecurityController {

    @RequestMapping("/login/form")
    public String loginForm(Model model) {

        return "home/security/login";
    }

    @RequestMapping("/login/register")
    public String registerForm(Model model) {

        return "home/security/register";
    }
}
