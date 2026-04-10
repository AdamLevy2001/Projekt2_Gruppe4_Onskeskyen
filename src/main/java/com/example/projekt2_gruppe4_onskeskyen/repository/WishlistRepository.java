package com.example.projekt2_gruppe4_onskeskyen.repository;

import com.example.projekt2_gruppe4_onskeskyen.model.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class WishlistRepository {

    @Autowired
    DataSource dataSource;

    public void save(Wishlist wishlist) {
        String sql = "INSERT INTO wishlist (id, name, user_"
    }
}
