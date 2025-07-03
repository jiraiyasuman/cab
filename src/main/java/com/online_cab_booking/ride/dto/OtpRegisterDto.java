package com.online_cab_booking.ride.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OtpRegisterDto {

	@Email
	@NotNull(message="email")
	@Schema(name="email cannot be null")
	private String email;
	@NotNull(message = "otp cannot be null")
	@Schema(name="otp")
	private String otp;
}
