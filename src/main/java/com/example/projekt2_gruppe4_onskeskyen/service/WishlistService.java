package com.example.projekt2_gruppe4_onskeskyen.service;

import com.example.projekt2_gruppe4_onskeskyen.model.Wishlist;
import com.example.projekt2_gruppe4_onskeskyen.repository.WishlistRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WishlistService {
    @Autowired
    WishlistRepository wishlistRepository;

    public void registrerWishlist(String name, HttpSession session){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Navn kan ikke være tomt");
        }

        Wishlist wishlist = new Wishlist(name, (Integer) session.getAttribute("userId"));
        wishlistRepository.saveWishlist(wishlist);
    }

    public ArrayList<Wishlist> getAllWishlistByUserID(int userID){
        return wishlistRepository.findWishlistsByUserId(userID);
    }

    public void updateServiceWishlist(int id, String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be empty");
        }
        Wishlist wishlist = new Wishlist(id, name, 0);
        wishlistRepository.updateWishlistName(wishlist);
    }

    public Wishlist getWishlistById(int id) {
        return wishlistRepository.getWishlistById(id);
    }
}
