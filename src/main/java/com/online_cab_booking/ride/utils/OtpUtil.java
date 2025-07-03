package com.online_cab_booking.ride.utils;

import java.security.SecureRandom;

public class OtpUtil {

	public static String generateOtp() {
		SecureRandom random = new SecureRandom();
		int otp = 100000 + random.nextInt(900000);
		return String.valueOf(otp);
	}
}
