package com.online_cab_booking.ride.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_cab_booking.ride.entity.Login;

public interface UserRepository extends JpaRepository<Login, Integer>{
	Login findByName(String name);
    Login findByEmail(String email);
	
}
