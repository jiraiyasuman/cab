package com.online_cab_booking.ride.mapper;

import com.online_cab_booking.ride.dto.LoginRequest;
import com.online_cab_booking.ride.entity.Login;

public class LoginMapper {

	Login loginObj = new Login();
	LoginRequest loginDtoObj = new LoginRequest();
	public Login mapToLogin(LoginRequest loginDto) {
		loginObj.setEmail(loginDto.getEmail());
		loginObj.setPassword(loginDto.getPassword());
		return loginObj;
	}
	
	public LoginRequest mapToLoginDto(Login login) {
		loginDtoObj.setEmail(login.getEmail());
		loginDtoObj.setPassword(login.getPassword());
		return loginDtoObj;
	}
}
