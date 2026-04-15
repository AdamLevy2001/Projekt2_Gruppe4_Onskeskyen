package com.example.projekt2_gruppe4_onskeskyen.repository;

import com.example.projekt2_gruppe4_onskeskyen.model.WishlistShare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class WishlistShareRepository {

    @Autowired
    private DataSource dataSource;

    public void saveWishlistShare(int wishlistId, int userId) {
        String sql = "INSERT INTO wishlist_share (wishlist_id, user_id) VALUES (?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, wishlistId);
            statement.setInt(2, userId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();


        }
    }

    public boolean hasAccess(int userId, int wishlistId){
        String sql = "SELECT COUNT(*) FROM wishlist_share WHERE user_id = ? AND wishlist_id = ?";

        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, userId);
            statement.setInt(2, wishlistId);

            var resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }
}
