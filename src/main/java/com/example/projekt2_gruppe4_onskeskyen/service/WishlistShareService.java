package com.example.projekt2_gruppe4_onskeskyen.service;

import com.example.projekt2_gruppe4_onskeskyen.repository.WishlistShareRepository;
import org.springframework.stereotype.Service;

@Service
public class WishlistShareService {

    private final WishlistShareRepository repository;

    public WishlistShareService(WishlistShareRepository repository) {
        this.repository=repository;
    }

    public void shareWishlist(int wishlistId, int userId) {
        repository.saveWishlistShare(wishlistId, userId);
    }
}
