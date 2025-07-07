package com.online_cab_booking.ride.serviceimpl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.online_cab_booking.ride.entity.RiderDetails;
import com.online_cab_booking.ride.exception.NotFoundException;
import com.online_cab_booking.ride.repository.RiderDetailsRepository;
import com.online_cab_booking.ride.service.RiderDetailsService;

public class RiderDetailsServiceImpl implements RiderDetailsService {
	private RiderDetailsRepository riderDetailsRepository;
	@Autowired
	public RiderDetailsServiceImpl(RiderDetailsRepository riderDetailsRepository) {
		super();
		this.riderDetailsRepository = riderDetailsRepository;
	}
	Logger LOGGER = Logger.getLogger(getClass().getName());
	@Override
	public RiderDetails saveRiderDetails(RiderDetails riderDetails) {
		RiderDetails savedRiderDetails = riderDetailsRepository.save(riderDetails);
		LOGGER.info("Saved Rider Details");
		return savedRiderDetails;
	}
	@Override
	public RiderDetails updateRiderDetails(RiderDetails riderDetails) {
		RiderDetails getByDetails = riderDetailsRepository.getById(riderDetails.getId());
		if (getByDetails == null)
			throw new NotFoundException("Rider Details are not found");
		getByDetails.setName(riderDetails.getName());
		getByDetails.setEmail(riderDetails.getEmail());
		getByDetails.setAddress(riderDetails.getAddress());
		getByDetails.setVehicleNumber(riderDetails.getVehicleNumber());
		getByDetails.setMobile(riderDetails.getMobile());
		getByDetails.setCity(riderDetails.getCity());
		getByDetails.setActive(riderDetails.isActive());
		getByDetails.setStatus(riderDetails.isStatus());
		RiderDetails updatedRiderDetails = riderDetailsRepository.save(getByDetails);
		LOGGER.info("Updated Rider Details");
		return updatedRiderDetails;
	}
	@Override
	public void deleteRiderDetails(String email) {
		RiderDetails getById = riderDetailsRepository.getRiderDetailsByEmail(email);
		if(getById == null)
			throw new NotFoundException("Rider Details not found successfully");
		riderDetailsRepository.delete(getById);
		LOGGER.info("Rider Details deleted successfully");
	}
	@Override
	public RiderDetails updateRiderRide(String mobile) {
		RiderDetails getByMobile = riderDetailsRepository.getRiderDetailsByMobile(mobile);
		if(getByMobile == null)
			throw new NotFoundException("Rider Details not found");
		getByMobile.setStatus(true);
		RiderDetails updatedRiderDetails = riderDetailsRepository.save(getByMobile);
		LOGGER.info("Updated Rider Details about rider availability");
		return updatedRiderDetails;
	}
	@Override
	public RiderDetails getRiderById(int id) {
		RiderDetails getById = riderDetailsRepository.getById(id);
		
		if(getById == null)
			throw new NotFoundException("Rider Details not found");
		LOGGER.info("Rider Details search query by id executed successfully");
		return getById;
	}
	@Override
	public RiderDetails getRiderByEmail(String email) {
		RiderDetails getById = riderDetailsRepository.getRiderDetailsByEmail(email);
		if(getById == null)
			throw new NotFoundException("Rider Details not found successfully");
		LOGGER.info("Rider Details fetched successfully");
		return getById;
	}
	@Override
	public List<RiderDetails> getRidersByAvailability() {
		List<RiderDetails> getAll = riderDetailsRepository.getAllRiderDetailsByStatus(true);
		if (getAll == null)
			throw new NotFoundException("Rider Details not found");
		return getAll;
	}
	@Override
	public List<RiderDetails> getAllRiders() {
		List<RiderDetails> getAll =  riderDetailsRepository.findAll();
		if(getAll == null)
			throw new NotFoundException("Rider Details not found");
		return getAll;
	}
	@Override
	public List<RiderDetails> getRidersByActive() {
		List<RiderDetails> getAll = riderDetailsRepository.getAllRiderDetailsByAvailability(true);
		if(getAll == null)
			throw new NotFoundException("Rider Details not found");
		return getAll;
	}
}
