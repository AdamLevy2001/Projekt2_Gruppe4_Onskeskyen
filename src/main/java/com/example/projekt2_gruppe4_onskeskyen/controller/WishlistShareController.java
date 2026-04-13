package com.example.projekt2_gruppe4_onskeskyen.controller;

import com.example.projekt2_gruppe4_onskeskyen.service.WishlistShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WishlistShareController {


@Autowired
    private final WishlistShareService service;

    public WishlistShareController(WishlistShareService service) {
        this.service=service;
    }

    @GetMapping("/wishlist/share")
    public String getWishlistShare() {
        return "wishlistShare";
    }

    @PostMapping("/wishlist/share")
    public String shareWishlist(@RequestParam int wishlistId,
                                @RequestParam int userId) {
        service.shareWishlist(wishlistId, userId);

        return "redirect:/showWishlist";
    }
}
