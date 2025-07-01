package com.online_cab_booking.ride.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;


public class LoginRequest {

	@Email
	@Schema(name="email")
	@NotNull(message = "Email id should not be null/blank/white space")
	private String email;
	@Schema(name="password")
	@NotNull(message = "password should not be null")
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginRequest(@Email @NotNull(message = "Email id should not be null/blank/white space") String email,
			@NotNull(message = "password should not be null") String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoginDto [email=" + email + ", password=" + password + "]";
	}
}
