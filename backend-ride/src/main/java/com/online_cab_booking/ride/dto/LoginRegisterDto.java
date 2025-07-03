package com.online_cab_booking.ride.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor@AllArgsConstructor
@Data
public class LoginRegisterDto {

	@Email
	@Schema(name="email")
	@NotNull(message="Email cannot be null")
	private String email;
	@Schema(name="password")
	@NotNull(message="Password cannot be null")
	private String password;
}
