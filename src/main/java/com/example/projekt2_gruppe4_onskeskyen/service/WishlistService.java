package com.example.projekt2_gruppe4_onskeskyen.service;

import com.example.projekt2_gruppe4_onskeskyen.model.User;
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
        User user = (User) session.getAttribute("loggedInUser");
        Wishlist wishlist = new Wishlist(name, user.getId());
        wishlistRepository.saveWishlist(wishlist);
    }

    public ArrayList<Wishlist> getAllWishlistByUserID(int userID){
        return wishlistRepository.findWishlistsByUserId(userID);
    }
}
