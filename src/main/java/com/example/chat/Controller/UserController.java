package com.example.chat.Controller;

import com.example.chat.Payloads.UserLoginInfo;
import com.example.chat.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/register/user")
    public ResponseEntity<String> registerUser(@RequestBody UserLoginInfo userLoginInfo) throws Exception {
        try {
            userService.registerUser(userLoginInfo);
            return ResponseEntity.ok("User Registration Success");
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            // Return an error response with the exception message
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User Registration Failed: " + e.getMessage());
        }
    }
}
