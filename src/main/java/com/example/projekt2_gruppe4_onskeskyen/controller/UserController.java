package com.example.projekt2_gruppe4_onskeskyen.controller;

import com.example.projekt2_gruppe4_onskeskyen.model.User;
import com.example.projekt2_gruppe4_onskeskyen.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/profile")
    public String showProfile(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }
        return "profile";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/user/delete")
    public String getWishlistShare() {
        return "deleteAccount";
    }

    @PostMapping("/user/delete")
    public String deleteUser(HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");

        userService.deleteUser(user.getId());

        session.invalidate();

        return "redirect:/";
    }

    @GetMapping("/user/search")
    public String searchUsers(@RequestParam(required = false) String query, Model model, HttpSession session) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }

        List<User> users;

        if (query == null || query.isEmpty()) {
            users = new ArrayList<>();
        } else {
            users = userService.searchUsers(query, user.getId());
        }


    @GetMapping("/profile/edit")
    public String editProfile(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        return "editProfile";
    }

    @PostMapping("/profile/edit")
    public String updateProfile(@RequestParam("name") String name,
                                @RequestParam("email") String email,
                                @RequestParam(value = "password", required = false) String password,
                                @RequestParam(value = "confirmPassword", required = false) String confirmPassword,
                                HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }
        try {
            userService.updateUserProfile(user.getId(), name, email, password, confirmPassword, session);
            return "redirect:/profile";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("user", new User(user.getId(), name, email, null));

        model.addAttribute("users", users);

        return "searchUsers";
    }
}


    @GetMapping("/profile/edit")
    public String editProfile(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        return "editProfile";
    }

    @PostMapping("/profile/edit")
    public String updateProfile(@RequestParam("name") String name,
                                @RequestParam("email") String email,
                                @RequestParam(value = "password", required = false) String password,
                                @RequestParam(value = "confirmPassword", required = false) String confirmPassword,
                                HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }
        try {
            userService.updateUserProfile(user.getId(), name, email, password, confirmPassword, session);
            return "redirect:/profile";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("user", new User(user.getId(), name, email, null));

            return "editProfile";
        }
    }
}
            return "editProfile";
        }
    }
}