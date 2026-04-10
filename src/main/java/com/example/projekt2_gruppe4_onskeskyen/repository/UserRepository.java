package com.example.projekt2_gruppe4_onskeskyen.repository;

import com.example.projekt2_gruppe4_onskeskyen.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class UserRepository {
    @Autowired
    DataSource dataSource;

    public void saveCreateUserToDB(User user){
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
