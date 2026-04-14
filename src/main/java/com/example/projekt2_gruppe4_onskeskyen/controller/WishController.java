package com.example.projekt2_gruppe4_onskeskyen.controller;

import com.example.projekt2_gruppe4_onskeskyen.model.Wish;
import com.example.projekt2_gruppe4_onskeskyen.repository.WishRepository;
import com.example.projekt2_gruppe4_onskeskyen.service.WishService;
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

    private final WishService wishService;


    public WishController(WishService wishService) {
        this.wishService = wishService;
    }

    @GetMapping("/wish/create")
    public String showCreateForm(Model model) {
        model.addAttribute("wish", new Wish(0, "", "", 0.0, "", 0));
        return "createWish";
    }

    @PostMapping("/wish/create")
    public String createWish(@ModelAttribute Wish wish) {

        wishService.createWish(
                wish.getName(),
                wish.getDescription(),
                wish.getPrice(),
                wish.getLink(),
                wish.getWishlistID());

        return "redirect:/";
    }

    @GetMapping("/wish/show")
    public String showWishes(@RequestParam("id") int id, Model model) {

        ArrayList<Wish> wishes = wishService.getWishesByWishlistId(id);
        model.addAttribute("wishes", wishes);

        return "showWishes";
    }
}
