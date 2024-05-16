package com.shadou.springboot.myWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    // simple, not recommended, authentication
    public boolean authenticate(String username, String password) {
        boolean isValidUsername = username.equalsIgnoreCase("Sarah");
        boolean isValidPassword = password.equalsIgnoreCase("password");
        return isValidUsername && isValidPassword;
    }

}
