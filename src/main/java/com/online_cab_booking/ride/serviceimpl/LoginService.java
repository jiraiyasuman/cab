package com.online_cab_booking.ride.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.online_cab_booking.ride.entity.Login;
import com.online_cab_booking.ride.repository.LoginRepository;
import com.online_cab_booking.ride.security.CustomUserDetails;

public class LoginService implements UserDetailsService{

	LoginRepository loginRepository;
	LoginAttemptServiceImpl loginAttemptServiceImpl;
	@Autowired
	public LoginService(LoginRepository loginRepository, LoginAttemptServiceImpl loginAttemptServiceImpl) {
		super();
		this.loginRepository = loginRepository;
		this.loginAttemptServiceImpl = loginAttemptServiceImpl;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Login login = loginRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No User Found"));
		if(login.isLocked()) {
			loginAttemptServiceImpl.unlockIfNeeded(login);
			if (login.isLocked()) 
				throw new LockedException("Account is locked");
		}
		return new CustomUserDetails(login);
	}
	
	public Login findByEmail(String email) 
	{
		return loginRepository.findByEmail(email).orElse(null); 
	}
}
