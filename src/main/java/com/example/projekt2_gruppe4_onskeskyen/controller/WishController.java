package com.example.projekt2_gruppe4_onskeskyen.controller;

import com.example.projekt2_gruppe4_onskeskyen.model.User;
import com.example.projekt2_gruppe4_onskeskyen.model.Wish;
import com.example.projekt2_gruppe4_onskeskyen.model.Wishlist;
import com.example.projekt2_gruppe4_onskeskyen.service.WishService;
import com.example.projekt2_gruppe4_onskeskyen.service.WishlistService;
import com.example.projekt2_gruppe4_onskeskyen.service.WishlistShareService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class WishController {
    @Autowired
    private WishService wishService;

    @Autowired
    private WishlistShareService wishlistShareService;

    @Autowired
    private WishlistService wishlistService;

    @GetMapping("/wish/create")
    public String showCreateForm(Model model, @RequestParam int wishlistId, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("wishlistId", wishlistId);
        return "createWish";
    }

    @PostMapping("/wish/create")
    public String createWish(@RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam("price") double price,
                             @RequestParam("link") String link,
                             @RequestParam("wishlistId") int wishlistId,
                             Model model) {

        try {
            wishService.createWish(name, description, price, link, wishlistId);
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("wishlistId", wishlistId);
            model.addAttribute("name", name);
            model.addAttribute("description", description);
            model.addAttribute("price", price);
            model.addAttribute("link", link);
            model.addAttribute("errorMessage", e.getMessage());
            return "createWish";
        }
    }

    @GetMapping("/wish/show")
    public String showWishes(@RequestParam("id") int wishlistId, Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");

        if(user == null){
            return "redirect:/login";
        }
        Wishlist wishlist = wishlistService.getWishlistById(wishlistId);
        boolean isOwner = user.getId() == wishlist.getUserID();
        boolean hasAccess = isOwner || wishlistShareService.hasAccess(user.getId(), wishlistId);

        if(!hasAccess){
            return "redirect:/";
        }

        ArrayList<Wish> wishes = wishService.getWishesByWishlistId(wishlistId);
        model.addAttribute("wishes", wishes);
        model.addAttribute("wishlistId", wishlistId);
        model.addAttribute("hasAccess", hasAccess);
        model.addAttribute("isOwner", isOwner);

        return "showWishes";
    }

    @PostMapping("/wish/reserve")
    public String reserveWishes(@RequestParam int wishId, HttpSession session, Model model){
        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }

        wishService.reserveWish(user.getId(), wishId);
        return "redirect:/wish/show?id=" + wishId;
    }
}
