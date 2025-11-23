package com.example.restaurant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class HomeController {

    @GetMapping("/H")
    public String homeh() {
        return "Welcome to the Restaurant Ordering API!";
    }
    
    @GetMapping("/")
    public RedirectView redirectToHome() {
        return new RedirectView("/swagger-ui/index.html");
    }
}
