package com.example.projekt2_gruppe4_onskeskyen.repository;

import com.example.projekt2_gruppe4_onskeskyen.model.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;


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
            stmt.setInt(5, wish.getWishlistId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Wish> findWishesByWishlistId(int wishlistID) {
        ArrayList<Wish> wishes = new ArrayList<>();
        String sql = "SELECT * FROM wish WHERE wishlist_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, wishlistID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Wish wish = new Wish(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getString("link"),
                        resultSet.getInt("wishlist_id")
                );
                wishes.add(wish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wishes;
    }

    public void reserveWish(int userId, int wishId){
        String sql = "INSERT INTO reservation (user_id, wish_id) VALUES (?, ?)";

        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, userId);
            statement.setInt(2, wishId);

            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean isWishReserved(int wishId){
        String sql = "SELECT COUNT(*) FROM reservation WHERE wish_id = ?";

        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, wishId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
