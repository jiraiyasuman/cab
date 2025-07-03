package com.online_cab_booking.ride.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.online_cab_booking.ride.entity.Login;
import com.online_cab_booking.ride.repository.UserRepository;
import com.online_cab_booking.ride.service.UserService;
import com.online_cab_booking.ride.utils.OtpUtil;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Login findByUsername(String email) {
        return userRepository.findByName(email);
    }

    @Override
    public void register(Login user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        String otp = OtpUtil.generateOtp();
        user.setOtp(otp);
        user.setOtpVerified(false);
        userRepository.save(user);
        emailService.sendOtp(user.getEmail(), otp);
    }

    @Override
    public String verifyOtp(String email, String otp) {
        Login user = userRepository.findByEmail(email);
        if (user != null && user.getOtp().equals(otp)) {
            user.setOtpVerified(true);
            userRepository.save(user);
            return "OTP verified successfully.";
        }
        return "Invalid OTP.";
    }

    @Override
    @Async
    @Cacheable(value = "userLogin", key = "#username")
    public String authenticate(String username, String password) {
        Login user = userRepository.findByName(username);
        if (user == null || !user.isOtpVerified()) {
            return "User not found or OTP not verified.";
        }

        if (!user.isAccountNonLocked()) {
            if (user.getLocalDateTime().plusHours(24).isBefore(LocalDateTime.now())) {
                user.setAccountNonLocked(true);
                user.setFailedAttempt(0);
            } else {
                return "Account is locked. Try again later.";
            }
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            user.setFailedAttempt(user.getFailedAttempt() + 1);
            if (user.getFailedAttempt() >= 5) {
                user.setAccountNonLocked(false);
                user.setLocalDateTime(LocalDateTime.now());
            }
            userRepository.save(user);
            return "Invalid credentials.";
        }

        user.setFailedAttempt(0);
        userRepository.save(user);

        return jwtService.generateToken(user.getEmail());
    }

	
}
