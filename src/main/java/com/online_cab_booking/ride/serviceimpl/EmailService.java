package com.online_cab_booking.ride.serviceimpl;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendOtp(String email, String otp) {
        // Simulate sending a styled OTP email
        String subject = "Your OTP Code for Cab Booking";
        String message = """
                ----------------------------------
                To: %s
                Subject: %s

                Dear user,

                Your One-Time Password (OTP) is: %s

                This OTP is valid for 5 minutes. Do not share it with anyone.

                Regards,
                Online Cab Booking Team
                ----------------------------------
                """.formatted(email, subject, otp);

        System.out.println(message);
    }
}
