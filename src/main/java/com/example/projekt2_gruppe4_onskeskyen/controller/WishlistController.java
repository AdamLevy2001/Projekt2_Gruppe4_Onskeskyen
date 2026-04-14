package com.example.projekt2_gruppe4_onskeskyen.controller;

import com.example.projekt2_gruppe4_onskeskyen.model.Wishlist;
import com.example.projekt2_gruppe4_onskeskyen.service.WishlistService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class WishlistController {

    @Autowired
    WishlistService wishlistService;

    @GetMapping("/createWishlist")
    public String createWishlist(HttpSession session) {
        Integer userID = (Integer) session.getAttribute("userId");

        if(userID == null){
            return "redirect:/login";
        }
        return "createWishlist";
    }

    @PostMapping("/createWishlist")
    public String postCreateWishlist(@RequestParam("name") String name,
                                     Model model,
                                     HttpSession session) {

        try {
            wishlistService.registrerWishlist(name, session);
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "createWishlist";
        }
    }

    @GetMapping("/showWishlists")
    public String showWishlists(HttpSession session, Model model){
        Integer userID = (Integer) session.getAttribute("userId");

        if(userID == null){
            return "redirect:/login";
        }

        ArrayList<Wishlist> wishlistArrayList = wishlistService.getAllWishlistByUserID(userID);

        model.addAttribute("wishlists", wishlistArrayList);

        return "showWishlists";
    }
}
