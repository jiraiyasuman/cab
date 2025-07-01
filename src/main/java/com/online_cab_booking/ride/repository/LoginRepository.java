package com.online_cab_booking.ride.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_cab_booking.ride.entity.Login;

public interface LoginRepository extends JpaRepository<Login , Integer >{
	
	Optional<Login> findByEmail(String email);

}
