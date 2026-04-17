package com.example.projekt2_gruppe4_onskeskyen.controller;

import com.example.projekt2_gruppe4_onskeskyen.model.User;
import com.example.projekt2_gruppe4_onskeskyen.model.Wishlist;
import com.example.projekt2_gruppe4_onskeskyen.service.UserService;
import com.example.projekt2_gruppe4_onskeskyen.service.WishlistService;
import com.example.projekt2_gruppe4_onskeskyen.service.WishlistShareService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WishlistShareController {

    @Autowired
    WishlistShareService wishlistShareService;

    @Autowired
    WishlistService wishlistService;

    @Autowired
    UserService userService;

    @GetMapping("/wishlist/share")
    public String getWishlistShare(@RequestParam(required = false) String query,
                                   @RequestParam(required = false) Integer wishlistId, Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");

        if(user == null){
            return "redirect:/login";
        }

        if (query != null && !query.isEmpty()) {
            List<User> searchResults = userService.searchUsers(query, user.getId());
            model.addAttribute("users", searchResults);
            model.addAttribute("query", query);
        }

        model.addAttribute("wishlistId", wishlistId);

        return "wishlistShare";
    }

    @PostMapping("/wishlist/share")
    public String shareWishlist(@RequestParam Integer wishlistId,
                                @RequestParam Integer userId,
                                HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }

        Wishlist wishlist = wishlistService.getWishlistById(wishlistId);
        boolean isOwner = user.getId() == wishlist.getUserID();
        if (!isOwner) {
            return "redirect:/";
        }

        try {
            wishlistShareService.shareWishlist(wishlistId, userId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }
}
