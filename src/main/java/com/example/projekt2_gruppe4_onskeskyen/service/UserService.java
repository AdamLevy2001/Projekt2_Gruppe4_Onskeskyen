package com.example.projekt2_gruppe4_onskeskyen.service;

import com.example.projekt2_gruppe4_onskeskyen.model.User;

public class UserService {

    public User createUser(String name, String email, String password) {
        if (name==null || email==null || password==null) {
            throw new IllegalArgumentException("Ugyldigt input!");
        }

        User user = new User(0, name, email, password);

        UserRepository.save(user);
        return user;
    }
}
