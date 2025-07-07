package com.online_cab_booking.ride.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity(name="ride_details")
public class RideDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="email",unique=true)
	private String email;
	@Column(name="from_place")
	private String fromPlace;
	@Column(name="to_place")
	private String toPlace;
	private Vehicle vehicle;
	@Column(name="type_of_vehicle")
	private String typeOfVehcle=vehicle.toString();
	@Column(name="local_date")
	private LocalDate localDate;
	@Column(name="local_time")
	private LocalTime localTime;
	@Column(name="local_date_time")
	private LocalDateTime localDateTime;
	@Column(name="fare")
	private double fare;
	@Column(name="driver_name")
	private String driverName;
	@Column(name="vehicle_number")
	private String vehcleNumber;
	@Column(name="status")
	private String status;
	@Column(name="from_latitude")
	private double fromLatitude;
	@Column(name="to_latitude")
	private double toLatitude;
	@Column(name="from_longitude")
	private double fromLongitude;
	@Column(name="to_longitude")
	private double toLongitude;
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
	public String getTypeOfVehcle() {
		return typeOfVehcle;
	}
	public void setTypeOfVehcle(String typeOfVehcle) {
		this.typeOfVehcle = typeOfVehcle;
	}
	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	public LocalTime getLocalTime() {
		return localTime;
	}
	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getVehcleNumber() {
		return vehcleNumber;
	}
	public void setVehcleNumber(String vehcleNumber) {
		this.vehcleNumber = vehcleNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getFromLatitude() {
		return fromLatitude;
	}
	public void setFromLatitude(double fromLatitude) {
		this.fromLatitude = fromLatitude;
	}
	public double getToLatitude() {
		return toLatitude;
	}
	public void setToLatitude(double toLatitude) {
		this.toLatitude = toLatitude;
	}
	public double getFromLongitude() {
		return fromLongitude;
	}
	public void setFromLongitude(double fromLongitude) {
		this.fromLongitude = fromLongitude;
	}
	public double getToLongitude() {
		return toLongitude;
	}
	public void setToLongitude(double toLongitude) {
		this.toLongitude = toLongitude;
	}
	public RideDetails(int id, String name, String email, String fromPlace, String toPlace, String typeOfVehcle,
			LocalDate localDate, LocalTime localTime, LocalDateTime localDateTime, double fare, String driverName,
			String vehcleNumber, String status, double fromLatitude, double toLatitude, double fromLongitude,
			double toLongitude) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.typeOfVehcle = typeOfVehcle;
		this.localDate = localDate;
		this.localTime = localTime;
		this.localDateTime = localDateTime;
		this.fare = fare;
		this.driverName = driverName;
		this.vehcleNumber = vehcleNumber;
		this.status = status;
		this.fromLatitude = fromLatitude;
		this.toLatitude = toLatitude;
		this.fromLongitude = fromLongitude;
		this.toLongitude = toLongitude;
	}
	
	public RideDetails(String name, String email, String fromPlace, String toPlace, double fare) {
		super();
		this.name = name;
		this.email = email;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.fare = fare;
	}
	public RideDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RideDetails [id=" + id + ", name=" + name + ", email=" + email + ", fromPlace=" + fromPlace
				+ ", toPlace=" + toPlace + ", typeOfVehcle=" + typeOfVehcle + ", localDate=" + localDate
				+ ", localTime=" + localTime + ", localDateTime=" + localDateTime + ", fare=" + fare + ", driverName="
				+ driverName + ", vehcleNumber=" + vehcleNumber + ", status=" + status + ", fromLatitude="
				+ fromLatitude + ", toLatitude=" + toLatitude + ", fromLongitude=" + fromLongitude + ", toLongitude="
				+ toLongitude + "]";
	}
}
