package com.online_cab_booking.ride.service;

import com.online_cab_booking.ride.entity.RideDetails;

public interface RideDetailsService {

	public double[] getLatitudeLongitudeFrom(String place) ;
	public double calculateDistance(double fromLatitude,double toLatitude,double toLongitude,double fromLongitude);
	public RideDetails saveToDatabase(RideDetails rideDetails);
	
}
