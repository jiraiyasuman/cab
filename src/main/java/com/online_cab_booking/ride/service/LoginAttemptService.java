package com.online_cab_booking.ride.service;

import com.online_cab_booking.ride.entity.Login;

public interface LoginAttemptService {

	public void loginSucceeded(Login login);
	public void loginFailed(Login login);
	public boolean unlockIfNeeded(Login login);
}
