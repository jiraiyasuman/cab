package com.online_cab_booking.ride.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online_cab_booking.ride.dto.RideDetailsDto;
import com.online_cab_booking.ride.entity.RideDetails;
import com.online_cab_booking.ride.entity.RiderDetails;
import com.online_cab_booking.ride.mapper.RideDetailsAutoMapper;
import com.online_cab_booking.ride.service.RideDetailsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
@RequestMapping("api/v1")
public class RideController {

	private RideDetailsService rideDetailsService;
	
	@Autowired
	public RideController(RideDetailsService rideDetailsService) {
		super();
		this.rideDetailsService = rideDetailsService;
	}
	RideDetailsAutoMapper rideDetailsAutoMapper = new RideDetailsAutoMapper();
	@PostMapping("ride_booking")
	public ResponseEntity<Map<String, Object>> getDistance(@RequestBody RideDetailsDto rideDetailsDto){
	
		 RideDetails riderDetails = rideDetailsAutoMapper.mapToRiderDetails(rideDetailsDto);
		 double [] targetLating = rideDetailsService.getLatitudeLongitudeFrom(riderDetails.getToPlace());
		 double distance = rideDetailsService.calculateDistance(riderDetails.getFromLatitude()
				 , targetLating[0]
						 , riderDetails.getFromLongitude(),
						 targetLating[1]);
	        rideDetailsService.saveToDatabase(riderDetails);
	        Map<String, Object> response = new HashMap<>();
	        response.put("distance", distance);
	        return ResponseEntity.ok(response);
	}
}
