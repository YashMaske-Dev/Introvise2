package com.Ok.Introvise.Controllers;


import com.Ok.Introvise.Models.User2;
import com.Ok.Introvise.Repositories.UserRepo2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController2 {

    private final UserRepo2 userRepository;

    public UserController2 (UserRepo2 userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String getCurrentUser(OAuth2AuthenticationToken authentication) {
        OAuth2User oAuth2User = authentication.getPrincipal();
        String userName = oAuth2User.getAttribute("name"); // This line is causing the exception
        return userName;
    }

    @GetMapping("/me")
    public String getUserDetails(){
        return "User Registered Succesfully";
    }

}
