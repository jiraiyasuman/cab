package com.online_cab_booking.ride.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class RiderDetailsDto {

	@Schema(name="name")
	@NotNull
	private String name;
	@Schema(name="email")
	@NotNull@Email
	private String email;
	@Schema(name="address")
	@NotNull
	private String address;
	@Schema(name="mobile")
	@NotNull
	private String mobile;
	@Schema(name="date_of_birth")
	@NotNull
	private LocalDate dateOfBirth;
	@Schema(name="vehicle_number")
	@NotNull
	private String vehicleNumber;
	@Schema(name="is_active")
	private boolean isActive;
	@Schema(name="status")
	private boolean status;
	@Schema(name="city")
	private String city;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public RiderDetailsDto(@NotNull String name, @NotNull @Email String email, @NotNull String address,
			@NotNull String mobile, @NotNull LocalDate dateOfBirth, @NotNull String vehicleNumber, boolean isActive,
			boolean status, String city) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.mobile = mobile;
		this.dateOfBirth = dateOfBirth;
		this.vehicleNumber = vehicleNumber;
		this.isActive = isActive;
		this.status = status;
		this.city = city;
	}
	public RiderDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RiderDetailsDto [name=" + name + ", email=" + email + ", address=" + address + ", mobile=" + mobile
				+ ", dateOfBirth=" + dateOfBirth + ", vehicleNumber=" + vehicleNumber + ", isActive=" + isActive
				+ ", status=" + status + ", city=" + city + "]";
	}
			
}
