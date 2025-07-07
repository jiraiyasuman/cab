package com.online_cab_booking.ride.mapper;

import com.online_cab_booking.ride.dto.RiderDetailsDto;
import com.online_cab_booking.ride.entity.RiderDetails;

public class RiderDetailAutoMapper {

	RiderDetails riderDetails = new RiderDetails();
	RiderDetailsDto riderDetailsDto = new RiderDetailsDto();
	
	public RiderDetails mapToRiderDetails(RiderDetailsDto riderDetailsDto) {
		riderDetails.setName(riderDetailsDto.getName());
		riderDetails.setEmail(riderDetailsDto.getEmail());
		riderDetails.setAddress(riderDetailsDto.getAddress());
		riderDetails.setMobile(riderDetailsDto.getMobile());
		riderDetails.setVehicleNumber(riderDetailsDto.getVehicleNumber());
		riderDetails.setDateOfBirth(riderDetailsDto.getDateOfBirth());
		riderDetails.setAddress(riderDetailsDto.getAddress());
		riderDetails.setActive(riderDetailsDto.isActive());
		riderDetails.setStatus(riderDetailsDto.isStatus());
		return riderDetails;
	}
	public RiderDetailsDto mapToRiderDetailsDto(RiderDetails riderDetails) {
		riderDetailsDto.setName(riderDetails.getName());
		riderDetailsDto.setEmail(riderDetails.getEmail());
		riderDetailsDto.setActive(riderDetails.isActive());
		riderDetailsDto.setAddress(riderDetails.getAddress());
		riderDetailsDto.setMobile(riderDetails.getMobile());
		riderDetailsDto.setVehicleNumber(riderDetails.getVehicleNumber());
		riderDetailsDto.setDateOfBirth(riderDetails.getDateOfBirth());
		riderDetailsDto.setStatus(riderDetails.isStatus());
		return riderDetailsDto;
	}
}