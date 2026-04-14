package com.example.projekt2_gruppe4_onskeskyen.service;

import com.example.projekt2_gruppe4_onskeskyen.model.User;
import com.example.projekt2_gruppe4_onskeskyen.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void registrerUser(String name, String email, String password){
        User existingUser = userRepository.findUserByEmail(email);

        if(existingUser != null){
            throw new IllegalArgumentException("Email findes allerede");
        }

        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Navn kan ikke være tomt");
        }

        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("Email kan ikke være tomt");
        }

        if(!email.contains("@")){
            throw new IllegalArgumentException("Email skal være gyldig");
        }

        if(password == null || password.length() < 8){
            throw new IllegalArgumentException("Password skal være mindst 8 tegn");
        }

        String hashedPassword = passwordEncoder.encode(password);

        User user = new User(name, email, hashedPassword);

        userRepository.saveCreateUserToDB(user);
    }

    public void loginUser(String email, String password, HttpSession session){
        User user = userRepository.findUserByEmail(email);

        if(user == null){
            throw new IllegalArgumentException("Email eller password er forkert");
        }

        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("Email eller password er forkert");
        }

        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new IllegalArgumentException("Email eller password er forkert");
        }

        session.setAttribute("loggedInUser", user);
    }
}
