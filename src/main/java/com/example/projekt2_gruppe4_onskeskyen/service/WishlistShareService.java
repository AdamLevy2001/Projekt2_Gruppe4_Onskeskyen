package com.example.projekt2_gruppe4_onskeskyen.service;

import com.example.projekt2_gruppe4_onskeskyen.repository.WishlistShareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishlistShareService {

    @Autowired
    private WishlistShareRepository repository;

    public void shareWishlist(int wishlistId, int userId) {
        repository.saveWishlistShare(wishlistId, userId);
    }

    public boolean hasAccess(int userId, int wishlistId){
        return repository.hasAccess(userId, wishlistId);
    }
}
