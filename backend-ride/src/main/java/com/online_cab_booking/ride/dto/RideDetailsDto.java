package com.online_cab_booking.ride.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class RideDetailsDto {
	@Schema(name="name") 
	private String name;
	@Schema(name="email")
	@NotNull@Email
	private String email;
	@Schema(name="from_place")
	@NotNull
	private String fromPlace;
	@Schema(name="to_place")
	@NotNull
	private String toPlace;
	@Schema(name="fare")
	@NotNull
	private double fare;
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
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public String getToPlace() {
		return toPlace;
	}
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public RideDetailsDto(String name, @NotNull @Email String email, @NotNull String fromPlace, @NotNull String toPlace,
			@NotNull double fare) {
		super();
		this.name = name;
		this.email = email;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.fare = fare;
	}
	public RideDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RideDetailsDto [name=" + name + ", email=" + email + ", fromPlace=" + fromPlace + ", toPlace=" + toPlace
				+ ", fare=" + fare + "]";
	}
	
}
