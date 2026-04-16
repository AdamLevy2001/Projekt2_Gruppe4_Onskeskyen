package com.example.projekt2_gruppe4_onskeskyen.service;

import com.example.projekt2_gruppe4_onskeskyen.model.User;
import com.example.projekt2_gruppe4_onskeskyen.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void registrerUser(String name, String email, String password) {
        User existingUser = userRepository.findUserByEmail(email);

        if (existingUser != null) {
            throw new IllegalArgumentException("Email findes allerede");
        }

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Navn kan ikke være tomt");
        }

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email kan ikke være tomt");
        }

        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email skal være gyldig");
        }

        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password skal være mindst 8 tegn");
        }

        String hashedPassword = passwordEncoder.encode(password);

        User user = new User(name, email, hashedPassword);

        userRepository.saveCreateUserToDB(user);
    }

    public void loginUser(String email, String password, HttpSession session) {
        User user = userRepository.findUserByEmail(email);

        if (user == null) {
            throw new IllegalArgumentException("Email eller password er forkert");
        }

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email eller password er forkert");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Email eller password er forkert");
        }

        session.setAttribute("loggedInUser", user);
    }

    public void deleteUser(int userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException();
        } else {
            userRepository.deleteUserById(userId);
        }
    }

    public List<User> searchUsers(String query, int currentUserId) {
        return userRepository.findUsersByName(query, currentUserId);
    }

    public void updateUserProfile(int userId, String newName, String newEmail, String newPassword, String confirmPassword, HttpSession session) {
        User existing = userRepository.findUserById(userId);
        if (existing == null) {
            throw new IllegalArgumentException("Bruger ikke fundet");
        }

        if (newName == null || newName.trim().isEmpty()) {
            throw new IllegalArgumentException("Navn må ikke være tomt");
        }

        if (newEmail == null || newEmail.trim().isEmpty()) {
            throw new IllegalArgumentException("Email må ikke være tomt");
        }
        if (!newEmail.contains("@")) {
            throw new IllegalArgumentException("Email skal være gyldigt");
        }

        User emailUser = userRepository.findUserByEmail(newEmail);
        if (emailUser != null && emailUser.getId() != userId) {
            throw new IllegalArgumentException("Email findes allerede");
        }

        String hashedPassword = existing.getPassword();

        if (newPassword != null && !newPassword.trim().isEmpty()) {
            if (newPassword.length() < 8) {
                throw new IllegalArgumentException("Adgangskoden skal være minimum 8 tegn");
            }
            if (!newPassword.equals(confirmPassword)) {
                throw new IllegalArgumentException("Adgangskoderne matcher ikke");
            }
            hashedPassword = passwordEncoder.encode(newPassword);
        }

        //Bruger-objektet opdateres
        User updatedUser = new User(userId, newName.trim(), newEmail.trim(), hashedPassword);
        userRepository.updateUser(updatedUser);

        session.setAttribute("loggedInUser", updatedUser);
    }

}
