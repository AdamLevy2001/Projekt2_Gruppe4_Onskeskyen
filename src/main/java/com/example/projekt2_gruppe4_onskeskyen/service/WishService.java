package com.example.projekt2_gruppe4_onskeskyen.service;

import com.example.projekt2_gruppe4_onskeskyen.model.Wish;
import com.example.projekt2_gruppe4_onskeskyen.repository.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WishService {
    @Autowired
    WishRepository wishRepository;

    public void createWish(String name, String description, double price, String link, int wishListId) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Navn mangler");
        }

        if (price < 0) {
            throw new IllegalArgumentException("Pris kan ikke være negativ");
        }

        Wish wish = new Wish(name, description, price, link, wishListId);

        wishRepository.save(wish);
    }

    public ArrayList<Wish> getWishesByWishlistId(int wishlistID) {
        return wishRepository.findWishesByWishlistId(wishlistID);
    }

    public void deleteWish(int wishId) {
        if (wishId <= 0) {
            throw new IllegalArgumentException();
        } else {
            wishRepository.deleteWishById(wishId);
        }
    }
}
