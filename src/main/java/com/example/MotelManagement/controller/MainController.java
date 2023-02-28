//package com.example.MotelManagement.controller;
//
//import com.example.MotelManagement.model.UserRegistrationDto;
//import com.example.MotelManagement.service.UserService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class MainController {
//    private UserService userService;
//
//    public MainController(UserService userService) {
//        this.userService = userService;
//    }
//    @GetMapping("home")
//    public String home(){
//        return "home";
//    }
//    @GetMapping("/login")
//    public String loginForm(){
//        return "login";
//    }
//    @GetMapping("registration")
//    public String showRegistrationForm(Model model){
//        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
//        model.addAttribute("user",userRegistrationDto);
//        return "registration";
//    }
//    @PostMapping("/registration/save")
//    public String registration(@Valid @ModelAttribute("user") UserRegistrationDto userRegistrationDto,
//                               BingingResult result)
//
//}
