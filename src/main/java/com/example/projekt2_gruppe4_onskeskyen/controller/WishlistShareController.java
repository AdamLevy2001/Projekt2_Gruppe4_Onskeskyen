package com.example.projekt2_gruppe4_onskeskyen.controller;

import com.example.projekt2_gruppe4_onskeskyen.model.User;
import com.example.projekt2_gruppe4_onskeskyen.model.Wishlist;
import com.example.projekt2_gruppe4_onskeskyen.service.WishlistService;
import com.example.projekt2_gruppe4_onskeskyen.service.WishlistShareService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WishlistShareController {

    @Autowired
    WishlistShareService service;

    @Autowired
    WishlistService wishlistService;

    @GetMapping("/wishlist/share")
    public String getWishlistShare(HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");

        if(user == null){
            return "redirect:/login";
        }
        return "wishlistShare";
    }

    @PostMapping("/wishlist/share")
    public String shareWishlist(@RequestParam int wishlistId,
                                @RequestParam int userId, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }

        Wishlist wishlist = wishlistService.getWishlistById(wishlistId);
        boolean isOwner = user.getId() == wishlist.getUserID();
        if (!isOwner) {
            return "redirect:/";
        }

        service.shareWishlist(wishlistId, userId);

        return "redirect:/showWishlists";
    }
}
