package com.example.projekt2_gruppe4_onskeskyen.repository;

import com.example.projekt2_gruppe4_onskeskyen.model.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<Wishlist> findWishlistsByUserId(int userID) {
        ArrayList<Wishlist> wishlistArrayList = new ArrayList<>();

        String sql = "SELECT * FROM wishlist WHERE user_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userID);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Wishlist wishlist = new Wishlist(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("user_id")
                );
                wishlistArrayList.add(wishlist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  wishlistArrayList;
    }
}
