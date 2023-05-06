package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void saveUser(User user) {
        // kod do zapisania użytkownika w bazie danych
        System.out.println("Saving user: " + user.getUsername());
    }
}