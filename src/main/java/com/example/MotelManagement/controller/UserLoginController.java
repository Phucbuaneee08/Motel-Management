package com.example.MotelManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class UserLoginController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
