package com.online_cab_booking.ride.mapper;

import com.online_cab_booking.ride.dto.OtpRegisterDto;
import com.online_cab_booking.ride.entity.Login;

public class OtpRegisterAutoMapper {

	Login login = new Login();
	OtpRegisterDto otpRegisterDto = new OtpRegisterDto();
	public Login mapToLogin(OtpRegisterDto otpRegisterDto) {
		login.setEmail(otpRegisterDto.getEmail());
		login.setOtp(otpRegisterDto.getOtp());
		return login;
	}
	public OtpRegisterDto mapToOtpRegisterDto(Login login) {
		otpRegisterDto.setEmail(login.getEmail());
		otpRegisterDto.setOtp(login.getOtp());
		return otpRegisterDto;
	}
}
