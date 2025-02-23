package com.interviewassistant.application.Services;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.interviewassistant.application.Models.User;
import com.interviewassistant.application.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepository;

    private final String GOOGLE_TOKEN_INFO_URL = "https://oauth2.googleapis.com/tokeninfo?id_token=";
    private final String CLIENT_ID = "315124824926-eojplkm74o08v3qrsqjuudqbkfctmnhl.apps.googleusercontent.com"; // Replace with your actual Client ID

    public User verifyOAuthToken(String token) {
        try {
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
                    new NetHttpTransport(),
                    new JacksonFactory()
            ).setAudience(Collections.singletonList(CLIENT_ID)).build();

            GoogleIdToken idToken = verifier.verify(token);
            if (idToken == null) {
                throw new RuntimeException("Invalid OAuth Token");
            }

            GoogleIdToken.Payload payload = idToken.getPayload();
            String email = payload.getEmail();
            String name = (String) payload.get("name");

            return userRepository.findByEmail(email)
                    .orElseGet(() -> {
                        User newUser = new User();
                        newUser.setEmail(email);
                        newUser.setName(name);
                        return userRepository.save(newUser);
                    });
        } catch (Exception e) {
            throw new RuntimeException("OAuth verification failed", e);
        }
    }

    public User verifyGoogleToken(String token) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            Map<String, Object> googleResponse = restTemplate.getForObject(GOOGLE_TOKEN_INFO_URL + token, Map.class);

            if (googleResponse == null || !googleResponse.containsKey("email")) {
                throw new RuntimeException("Invalid Google Token");
            }

            String email = (String) googleResponse.get("email");
            String name = (String) googleResponse.get("name");
            String googleId = (String) googleResponse.get("sub"); // Unique Google ID
            String provider = "GOOGLE";

            // Ensure `findByEmail` returns Optional<User>
            Optional<User> existingUser = userRepository.findByEmail(email);

            return existingUser.orElseGet(() -> {
                User newUser = new User(email, name, googleId, provider, token);
                return userRepository.save(newUser);
            });

        } catch (Exception e) {
            throw new RuntimeException("Google Token verification failed", e);
        }
    }
    public boolean validateUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent() && user.get().getPassword().equals(password);
    }
}


