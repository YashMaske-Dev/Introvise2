package com.interviewassistant.application.Controllers;


import com.interviewassistant.application.DTO.UserDTO;
import com.interviewassistant.application.Models.User;

import com.interviewassistant.application.Repositories.UserRepo;
import com.interviewassistant.application.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173") // Allow React frontend
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepo userRepository;


    @PostMapping("/login")
    public ResponseEntity<UserDTO> googleLogin(@RequestBody Map<String, Object> request) {
        String token = (String) request.get("token");
        User user = authService.verifyGoogleToken(token);

        if (user != null) {
            UserDTO userDTO = new UserDTO(user.getEmail(), user.getName());
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/login1")
    public ResponseEntity<?> handleSignIn(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        if (email == null || password == null) {
            return ResponseEntity.badRequest().body("Email and password are required");
        }

        boolean isValidUser = authService.validateUser(email, password);

        if (isValidUser) {
            return ResponseEntity.ok(Map.of("email", email, "message", "Login successful"));
        } else {
            return ResponseEntity.status(401).body("User not found or incorrect password");
        }
    }
}
