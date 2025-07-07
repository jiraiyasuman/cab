package com.online_cab_booking.ride.service;

import java.util.List;

import com.online_cab_booking.ride.dto.RiderDetailsDto;
import com.online_cab_booking.ride.entity.RiderDetails;

public interface RiderDetailsService {

	public RiderDetails saveRiderDetails(RiderDetails riderDetails);
	public RiderDetails updateRiderDetails(RiderDetails riderDetails);
	public void deleteRiderDetails(String email);
	public RiderDetails updateRiderRide(String mobile);
	public RiderDetails getRiderById(int id);
	public RiderDetails getRiderByEmail(String email);
	public List<RiderDetails> getRidersByAvailability();
	public List<RiderDetails> getAllRiders();
	public List<RiderDetails> getRidersByActive();
}
