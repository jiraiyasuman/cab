package com.online_cab_booking.ride.mapper;

import com.online_cab_booking.ride.dto.LoginRegisterDto;
import com.online_cab_booking.ride.entity.Login;

public class LoginRegisterAutoMapper {

	Login login = new Login();
	LoginRegisterDto loginRegisterDto = new LoginRegisterDto();
	
	public Login mapToLogin(LoginRegisterDto loginRegisterDto) {
		login.setEmail(loginRegisterDto.getEmail());
		login.setPassword(loginRegisterDto.getPassword());
		return login;
	}
	
	public LoginRegisterDto mapLoginRegisterDto(Login login) {
		loginRegisterDto.setEmail(login.getEmail());
		loginRegisterDto.setPassword(login.getPassword());
		return loginRegisterDto;
	}
}
