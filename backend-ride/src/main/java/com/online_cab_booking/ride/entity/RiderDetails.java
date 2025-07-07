package com.online_cab_booking.ride.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class RiderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="address")
	private String address;
	@Column(name="mobile")
	private String mobile;
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	@Column(name="vehicle_number")
	private String vehicleNumber;
	@Column(name="is_active")
	private boolean isActive;
	@Column(name="status")
	private boolean status;
	@Column(name="city")
	private String city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public RiderDetails(int id, String name, String email, String address, String mobile, LocalDate dateOfBirth,
			String vehicleNumber, boolean isActive, boolean status, String city) {
		super();
		this.id = id;
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
	public RiderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RiderDetails [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", mobile="
				+ mobile + ", dateOfBirth=" + dateOfBirth + ", vehicleNumber=" + vehicleNumber + ", isActive="
				+ isActive + ", status=" + status + ", city=" + city + "]";
	}	
}
