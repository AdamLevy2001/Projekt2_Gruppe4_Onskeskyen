package com.example.projekt2_gruppe4_onskeskyen.service;

import com.example.projekt2_gruppe4_onskeskyen.model.Wish;
import com.example.projekt2_gruppe4_onskeskyen.repository.WishRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WishService {
    private final WishRepository wishRepository;


    public WishService(WishRepository wishRepository) {
        this.wishRepository = wishRepository;
    }

    public void createWish(String name, String description, double price, String link, int wishListId) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Navn mangler");
        }

        Wish wish = new Wish(0, name, description, price, link, wishListId);

        wishRepository.save(wish);
    }

    public ArrayList<Wish> getWishesByWishlistId(int wishlistID) {
        return wishRepository.findWishesByWishlistId(wishlistID);
    }
}
