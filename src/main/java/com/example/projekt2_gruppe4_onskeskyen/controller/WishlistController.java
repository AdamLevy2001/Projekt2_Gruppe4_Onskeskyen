package com.example.projekt2_gruppe4_onskeskyen.controller;

import com.example.projekt2_gruppe4_onskeskyen.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WishlistController {

    @Autowired
    WishlistService wishlistService;

    @GetMapping("/createWishlist")
    public String createWishlist() {
        return "createWishlist";
    }

    @PostMapping("/createWishlist")
    public String postCreateWishlist(@RequestParam("name") String name,
                                     @RequestParam("userID") int userID,
                                     Model model) {

        try {
            wishlistService.registrerWishlist(name, userID);
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "createUser";
        }
    }
}
