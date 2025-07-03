package com.online_cab_booking.ride.mapper;

import com.online_cab_booking.ride.dto.LoginRegisterDto;
import com.online_cab_booking.ride.dto.RegisterDto;
import com.online_cab_booking.ride.entity.Login;

public class RegisterAutoMapper {
	
	RegisterDto registerDto = new RegisterDto();
	Login login = new Login();
	public Login mapToLogin(RegisterDto registerDto) {
		login.setName(registerDto.getName());
		login.setEmail(registerDto.getEmail());
		login.setPassword(registerDto.getPassword());
		login.setRole(registerDto.getRole());
		return login ;
	}
	
	public RegisterDto mapToRegisterDto(Login login) {
		registerDto.setEmail(login.getEmail());
		registerDto.setName(login.getName());
		registerDto.setPassword(login.getPassword());
		registerDto.setRole(login.getRole());
		return registerDto;
	}
	
	

}
