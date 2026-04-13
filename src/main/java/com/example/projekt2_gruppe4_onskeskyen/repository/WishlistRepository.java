package com.example.projekt2_gruppe4_onskeskyen.repository;

import com.example.projekt2_gruppe4_onskeskyen.model.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class WishlistRepository {

    @Autowired
    private DataSource dataSource;

    public void saveWishlist(Wishlist wishlist) {
        String sql = "INSERT INTO wishlist (name, user_id) VALUES (?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, wishlist.getName());
            statement.setInt(2, wishlist.getUserID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
