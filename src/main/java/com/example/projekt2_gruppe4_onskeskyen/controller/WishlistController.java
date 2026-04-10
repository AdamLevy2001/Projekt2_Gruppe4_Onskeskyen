package com.example.projekt2_gruppe4_onskeskyen.controller;

import com.example.projekt2_gruppe4_onskeskyen.model.Wishlist;
import com.example.projekt2_gruppe4_onskeskyen.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WishlistController {

    @Autowired
    WishlistRepository wishlistRepo;

    @GetMapping("/getCreateWishlist")
    public String createWishlist() {
        return "createWishlist";
    }

    @PostMapping("/saveCreateWishlist")
    public String postCreateWishlist(@RequestParam("name") String name,
                                     @RequestParam("userID") int userID) {

        Wishlist wishlist = new Wishlist(name, userID);
        wishlistRepo.save(wishlist);
        return "redirect:/";

    }
}
