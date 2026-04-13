package com.example.projekt2_gruppe4_onskeskyen.repository;

import com.example.projekt2_gruppe4_onskeskyen.model.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@Repository
public class WishRepository {

    @Autowired
    private DataSource dataSource;

    public void save(Wish wish) {
        String sql = "INSERT INTO wish (name, description, price, link, wishlist_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, wish.getName());
            stmt.setString(2, wish.getDescription());
            stmt.setDouble(3, wish.getPrice());
            stmt.setString(4, wish.getLink());
            stmt.setInt(5, wish.getWishlistID());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
