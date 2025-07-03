package com.online_cab_booking.ride.service;

import com.online_cab_booking.ride.entity.Login;

public interface UserService {
	    Login findByUsername(String username);
	    String authenticate(String username, String password);
	    String verifyOtp(String email, String otp);
	    void register(Login user);

	
}
