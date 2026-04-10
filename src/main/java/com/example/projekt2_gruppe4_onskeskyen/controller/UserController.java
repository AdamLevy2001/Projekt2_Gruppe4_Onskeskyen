package com.example.projekt2_gruppe4_onskeskyen.controller;

import com.example.projekt2_gruppe4_onskeskyen.model.User;
import com.example.projekt2_gruppe4_onskeskyen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("getCreateUser")
    public String createUser(){
        return "createUser";
    }

    @PostMapping("/saveCreateUser")
    public String postCreateUser(@RequestParam("name") String name,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password){

        User user = new User(name, email, password);

        userRepository.saveCreateUserToDB(user);

        return "redirect:/";
    }
}
