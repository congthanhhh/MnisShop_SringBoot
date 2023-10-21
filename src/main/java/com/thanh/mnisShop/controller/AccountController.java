package com.thanh.mnisShop.controller;

import com.thanh.mnisShop.model.Account;
import com.thanh.mnisShop.model.Role;
import com.thanh.mnisShop.service.AccountService;
import com.thanh.mnisShop.service.RoleService;
import com.thanh.mnisShop.service.UploadImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/home")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UploadImageService uploadImageService;

    @GetMapping("/register")
    public String form(Model model) {

        Account account = new Account();
        model.addAttribute("account", account);
        return "home/security/register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute("account") Account account, @RequestParam String roleName,
                           @RequestParam MultipartFile img) {

        account.setPhoto(img != null ? img.getOriginalFilename() : null);

        Role role = roleService.findById(roleName);
        accountService.create(account,role);

        // Tạo một đối tượng mới của ImageService và gọi phương thức saveImage

        if (img != null) {
//            String uploadPath = "E:/cloneGithub/cloneGit/SE/upload";
            String uploadPath = "src/main/resources/static/assets/home/img";
            uploadImageService.saveImage(img, uploadPath);
        }
        model.addAttribute("registerMessage", "Register successfully!");

        return "home/security/register";

    }


    @ModelAttribute("roles")
    public List<Role> getRoles() {
        return roleService.findAll();
    }
}
