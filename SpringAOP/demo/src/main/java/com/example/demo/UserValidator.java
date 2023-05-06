package com.example.demo;

import com.example.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator {

    public Boolean validate(User user)
    {
        Boolean isUserCorrect = Boolean.valueOf(true);

        if (user.getUsername() == null || user.getUsername().isEmpty())
        {
            System.out.println("Username cannot be empty");
            isUserCorrect = false;
        }

        if (user.getPassword() == null || user.getPassword().isEmpty())
        {
            System.out.println("Password cannot be empty");
            isUserCorrect = false;
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher matcher = emailPattern.matcher(user.getEmail());
        if(matcher.matches() == false)
        {
            System.out.println("Incorrect email");
            isUserCorrect = false;
        }
        return isUserCorrect;
    }
}