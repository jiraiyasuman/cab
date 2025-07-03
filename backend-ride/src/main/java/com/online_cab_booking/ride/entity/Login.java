package com.online_cab_booking.ride.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name="login")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name",nullable = false)
	private String name;
	@Column(name="email",nullable = false,unique = true)
	private String email;
	@Column(name="password",nullable = false)
	private String password;
	@Column(name="role",nullable = false)
	private String role;
	@Column(name="otp",nullable = true)
	private String otp;
	@Column(name="otp_verified",nullable = true)
	private boolean otpVerified;
	@Column(name="failed_attempt",nullable=true)
	private int failedAttempt=0;
	@Column(name="account_non_locked",nullable = true)
	private boolean accountNonLocked = true;
	@Column(name="local_date_time",nullable = true)
	private LocalDateTime localDateTime;
}
