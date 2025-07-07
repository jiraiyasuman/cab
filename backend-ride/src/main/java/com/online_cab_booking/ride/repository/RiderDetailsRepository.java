package com.online_cab_booking.ride.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_cab_booking.ride.entity.RiderDetails;

public interface RiderDetailsRepository extends JpaRepository<RiderDetails, Integer>{

	public RiderDetails getRiderDetailsByEmail(String email);
	public RiderDetails getRiderDetailsByMobile(String mobile);
	public List<RiderDetails> getAllRiderDetailsByAvailability(boolean status);
	public List<RiderDetails> getAllDetails();
	public List<RiderDetails> getAllRiderDetailsByStatus(boolean isActive);
}
