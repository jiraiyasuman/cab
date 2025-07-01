package com.online_cab_booking.ride.entity;

import java.awt.datatransfer.Transferable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name = "email" , unique = true)
	private String email;
	@Column(name ="password")
	private String password;
	@Column(name = "role")
	private String role;
	@Column(name="failed_attempts")
	private int failedAttempts=0;
	@Column(name="is_locked")
	private boolean isLocked=false;
	@Column(name="local_date_time")
	private LocalDateTime localDateTime;
	@Column(name="is_enabled")
	private boolean isEnabled;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getFailedAttempts() {
		return failedAttempts;
	}
	public void setFailedAttempts(int failedAttempts) {
		this.failedAttempts = failedAttempts;
	}
	public boolean isLocked() {
		return isLocked;
	}
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public Login(int id, String email, String password, String role, int failedAttempts, boolean isLocked,
			LocalDateTime localDateTime, boolean isEnabled) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.failedAttempts = failedAttempts;
		this.isLocked = isLocked;
		this.localDateTime = localDateTime;
		this.isEnabled = isEnabled;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", failedAttempts=" + failedAttempts + ", isLocked=" + isLocked + ", localDateTime=" + localDateTime
				+ ", isEnabled=" + isEnabled + "]";
	}
	
}
