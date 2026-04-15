package com.example.projekt2_gruppe4_onskeskyen.controller;

import com.example.projekt2_gruppe4_onskeskyen.model.User;
import com.example.projekt2_gruppe4_onskeskyen.model.Wishlist;
import com.example.projekt2_gruppe4_onskeskyen.model.WishlistShare;
import com.example.projekt2_gruppe4_onskeskyen.service.WishlistService;
import com.example.projekt2_gruppe4_onskeskyen.service.WishlistShareService;
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

    @Autowired
    WishlistShareService wishlistShareService;

    @GetMapping("/createWishlist")
    public String createWishlist(HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");

        if(user == null){
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
    public String showWishlists(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }

        ArrayList<Wishlist> wishlistArrayList = wishlistService.getAllWishlistByUserID(user.getId());

        ArrayList<Wishlist> sharedWishlists = wishlistShareService.getSharedWishlists(user.getId());
        model.addAttribute("wishlists", wishlistArrayList);
        model.addAttribute("sharedWishlists", sharedWishlists);
        return "showWishlists";
    }

    @GetMapping("/getUpdateWishlist")
    public String updateWishlist(@RequestParam("id") int id, Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }
        Wishlist wishlist = wishlistService.getWishlistById(id);
        model.addAttribute("wishlist", wishlist);
        return "updateWishlist";
    }

    @PostMapping("/saveUpdateWishlist")
    public String postupdateWishlist(@RequestParam("id") int id,
                                     @RequestParam("name") String name) {
        wishlistService.updateServiceWishlist(id, name);
        return "redirect:/showWishlists";
    }
}
