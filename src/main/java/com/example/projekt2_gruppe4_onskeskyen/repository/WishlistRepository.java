package com.example.projekt2_gruppe4_onskeskyen.repository;

import com.example.projekt2_gruppe4_onskeskyen.model.Wish;
import com.example.projekt2_gruppe4_onskeskyen.model.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.SQL;
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

        return wishlistArrayList;
    }

    public void updateWishlistName(Wishlist updateWishlist) {
        String sql = "UPDATE wishlist SET name = ? WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, updateWishlist.getName());
            statement.setInt(2, updateWishlist.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Wishlist getWishlistById(int id) {
        String sql = "SELECT * FROM wishlist WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Wishlist(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("user_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isOwnerOfWish(int userId, int wishId) {
        String sql = "SELECT COUNT(*) FROM wish JOIN wishlist ON wish.wishlist_id = wishlist.id WHERE wish.id = ? AND wishlist.user_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, wishId);
            statement.setInt(2, userId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Wish getWishlistByWishId(int wishId) {
        String sql = "SELECT wishlist_id FROM wish WHERE wish_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, wishId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Wish(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getString("link"),
                        resultSet.getInt("wishlist_id")
                );
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void deleteWishlist(int id) {
        String sql = "DELETE FROM wishlist WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
