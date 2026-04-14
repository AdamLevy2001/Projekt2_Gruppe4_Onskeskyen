package com.example.projekt2_gruppe4_onskeskyen.controller;

import com.example.projekt2_gruppe4_onskeskyen.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/createUser")
    public String createUserPage() {
        return "createUser";
    }

    @PostMapping("/createUser")
    public String postCreateUser(@RequestParam("name") String name,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password,
                                 Model model) {
        try {
            userService.registrerUser(name, email, password);
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("name", name);
            model.addAttribute("email", email);
            model.addAttribute("errorMessage", e.getMessage());
            return "createUser";
        }
    }

    @GetMapping("/login")
    public String loginPage() {
        return "userLogin";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            Model model,
                            HttpSession session) {
        try {
            userService.loginUser(email, password, session);
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("email", email);
            model.addAttribute("errorMessage", e.getMessage());
            return "userLogin";
        }
    }
    @GetMapping ("/profile")
    public String showProfile(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }


        String userName = (String) session.getAttribute("userName");
        String userEmail = (String) session.getAttribute("email");

        model.addAttribute("userId", userId);
        model.addAttribute("name", userName);
        model.addAttribute("email", userEmail);


        return "profile";

    }@GetMapping("/user/delete")
    public String getWishlistShare() {
        return "deleteAccount";
    }

    @PostMapping("/user/delete")
    public String deleteUser(HttpSession session) {

        int userId = (int) session.getAttribute("userId");

        userService.deleteUser(userId);

        session.invalidate();

        return "redirect:/";
    }
}
