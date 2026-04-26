package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.security.MyCustomUserDetails;


@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String showUserPage(Model model, Authentication authentication) {
        MyCustomUserDetails details = (MyCustomUserDetails) authentication.getPrincipal();
        model.addAttribute("user", details.getUser());
        return "user";
    }
}
