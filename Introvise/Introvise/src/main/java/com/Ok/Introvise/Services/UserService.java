//package com.Ok.Introvise.Services;
//
//import com.Ok.Introvise.Models.User;
//import com.Ok.Introvise.Repositories.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepo userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public User registerUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash password before saving
//        return userRepository.save(user);
//    }
//
//    public Object getUserByEmail(String email, String password) {
//        // Get currently authenticated user
//        String loggedInEmail = SecurityContextHolder.getContext().getAuthentication().getName();
//
//        // Allow users to fetch their own details without authentication
//        if (loggedInEmail.equals(email)) {
//            return userRepository.findByEmail(email)
//                    .orElseThrow(() -> new RuntimeException("User not found"));
//        }
//
//        // If fetching someone else's details, verify password
//        Optional<User> userOptional = userRepository.findByEmail(email);
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            if (passwordEncoder.matches(password, user.getPassword())) {
//                return user; // Return user details if password matches
//            } else {
//                return "Unauthorized access: Incorrect password";
//            }
//        }
//
//        return "User not found";
//    }
//}
