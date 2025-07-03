package com.online_cab_booking.ride.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.online_cab_booking.ride.dto.LoginRegisterDto;
import com.online_cab_booking.ride.entity.Login;
import com.online_cab_booking.ride.mapper.LoginRegisterAutoMapper;
import com.online_cab_booking.ride.service.UserService;

@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    LoginRegisterAutoMapper loginRegisterAutoMapper = new LoginRegisterAutoMapper();

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody LoginRegisterDto user) {
        Login loginRegisterDto = loginRegisterAutoMapper.mapToLogin(user);
        userService.register(loginRegisterDto);
        return ResponseEntity.ok("User registered. OTP sent to email.");
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestParam String email, @RequestParam String otp) {
        return ResponseEntity.ok(userService.verifyOtp(email, otp));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        String token = userService.authenticate(username, password);
        if (token.equals("Invalid credentials.") || token.contains("locked") || token.contains("OTP")) {
            return ResponseEntity.badRequest().body(token);
        }
        return ResponseEntity.ok("JWT Token: " + token);
    }

    @GetMapping("/user/home")
    public String userHome() {
        return "Welcome USER";
    }

    @GetMapping("/admin/home")
    public String adminHome() {
        return "Welcome ADMIN";
    }
}
