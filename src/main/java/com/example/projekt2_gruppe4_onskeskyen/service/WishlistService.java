package com.example.projekt2_gruppe4_onskeskyen.service;

import com.example.projekt2_gruppe4_onskeskyen.model.Wishlist;
import com.example.projekt2_gruppe4_onskeskyen.repository.UserRepository;
import com.example.projekt2_gruppe4_onskeskyen.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishlistService {
    @Autowired
    WishlistRepository wishlistRepository;

    public void registrerWishlist(String name, int userID){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Navn kan ikke være tomt");
        }

        Wishlist wishlist = new Wishlist(name, userID);
        wishlistRepository.saveWishlist(wishlist);
    }
}
