package com.online_cab_booking.ride.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_cab_booking.ride.entity.RideDetails;

public interface RideRepository extends JpaRepository<RideDetails, Integer>{

}
