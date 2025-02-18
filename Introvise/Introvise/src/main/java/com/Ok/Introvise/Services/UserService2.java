package com.Ok.Introvise.Services;

import com.Ok.Introvise.Models.User2;
import com.Ok.Introvise.Repositories.UserRepo2;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService2 {

    private final UserRepo2 userRepository;

    public UserService2(UserRepo2 userRepository) {
        this.userRepository = userRepository;
    }

    public User2 processOAuthPostLogin(OAuth2User oAuth2User) {
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        String providerId = oAuth2User.getAttribute("sub");

        Optional<User2> existingUser = userRepository.findByEmail(email);

        if (existingUser.isEmpty()) {
            // New User - Save in DB
            User2 newUser = new User2();
            newUser.setEmail(email);
            newUser.setName(name);
            newUser.setProvider("google");
            newUser.setProviderId(providerId);

            return userRepository.save(newUser);
        }
        return existingUser.get();
    }
}
