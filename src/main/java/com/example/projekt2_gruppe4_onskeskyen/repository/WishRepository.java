package com.example.projekt2_gruppe4_onskeskyen.repository;

import com.example.projekt2_gruppe4_onskeskyen.model.Wish;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@Repository
public class WishRepository {

    public void save(Wish wish) {
        String sql = "INSERT INTO wish (name, description, price, link, wishlist_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "pass");
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, wish.getName());
            stmt.setString(2, wish.getDescription());
            stmt.setDouble(3, wish.getPrice());
            stmt.setString(4, wish.getLink());
            stmt.setInt(5, wish.getWishlist_ID());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
