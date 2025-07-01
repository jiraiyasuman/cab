package com.online_cab_booking.ride.serviceimpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.online_cab_booking.ride.entity.Login;
import com.online_cab_booking.ride.repository.LoginRepository;
import com.online_cab_booking.ride.service.LoginAttemptService;

public class LoginAttemptServiceImpl implements LoginAttemptService{

	private LoginRepository loginRepository;
	
	@Autowired
	public LoginAttemptServiceImpl(LoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
	}

	@Override
	public void loginSucceeded(Login login) {
		login.setFailedAttempts(0);
		loginRepository.save(login);
	}

	@Override
	public void loginFailed(Login login) {
		login.setFailedAttempts(login.getFailedAttempts()+1);
		if(login.getFailedAttempts()>=5) {
			login.setLocked(true);
			login.setLocalDateTime(LocalDateTime.now());
		}
		loginRepository.save(login);
	}

	@Override
	public boolean unlockIfNeeded(Login login) {
		if(login.isLocked()&& login.getLocalDateTime().plusHours(24).isBefore(LocalDateTime.now())) {
			login.setLocked(false);
			login.setFailedAttempts(0);
			login.setLocalDateTime(null);
			loginRepository.save(login);
			return true;
		}
		return false;
	}

}
