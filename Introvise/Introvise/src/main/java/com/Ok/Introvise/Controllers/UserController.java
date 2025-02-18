//package com.Ok.Introvise.Controllers;
//
//import com.Ok.Introvise.Models.User;
//import com.Ok.Introvise.Services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/register")
//    public ResponseEntity<User> registerUser(@RequestBody User user) {
//        User registeredUser = userService.registerUser(user);
//        return ResponseEntity.ok(registeredUser);
//    }
//
//    @GetMapping("/email/{email}")
//    public ResponseEntity<?> getUserByEmail(@PathVariable String email,
//                                            @RequestParam(required = false) String password) {
//        Object response = userService.getUserByEmail(email, password);
//        if (response instanceof User) {
//            return ResponseEntity.ok(response);
//        }
//        return ResponseEntity.status(403).body(response); // 403 Forbidden for unauthorized access
//    }
//
//
//}
