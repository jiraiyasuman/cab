package com.online_cab_booking.ride.mapper;

import com.online_cab_booking.ride.dto.RideDetailsDto;
import com.online_cab_booking.ride.entity.RideDetails;

public class RideDetailsAutoMapper {

	RideDetails rideDetails = new RideDetails();
	RideDetailsDto rideDetailsDto = new RideDetailsDto();
	
	public RideDetails mapToRiderDetails(RideDetailsDto rideDetailsDto) {
	    rideDetails.setDriverName(rideDetailsDto.getName());
	    rideDetails.setEmail(rideDetailsDto.getEmail());
	    rideDetails.setFromPlace(rideDetailsDto.getFromPlace());
	    rideDetails.setToPlace(rideDetailsDto.getToPlace());
	    rideDetails.setFare(rideDetailsDto.getFare());
	    return rideDetails;
	}
	
	public RideDetailsDto mapToRiderDetailsDto(RideDetails rideDetails) {
		rideDetailsDto.setEmail(rideDetails.getEmail());
		rideDetailsDto.setName(rideDetails.getName());
		rideDetailsDto.setFromPlace(rideDetails.getFromPlace());
		rideDetailsDto.setToPlace(rideDetails.getToPlace());
		rideDetailsDto.setFare(rideDetails.getFare());
		return rideDetailsDto;
	}
}
