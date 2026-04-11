package com.example.projekt2_gruppe4_onskeskyen.controller;

import com.example.projekt2_gruppe4_onskeskyen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("getCreateUser")
    public String createUser(){
        return "createUser";
    }

    @PostMapping("/saveCreateUser")
    public String postCreateUser(@RequestParam("name") String name,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password){

        userService.registrerUser(name, email, password);

        return "redirect:/";
    }
}
