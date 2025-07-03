package com.online_cab_booking.ride.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor@AllArgsConstructor
@Data
public class RegisterDto {

	@Email
	@NotNull(message = "email")
	@Schema(name="email")
	private String email;
	@NotNull(message="name")
	@Schema(name="name")
	private String name;
	@NotNull(message="password cannot be null")
	@Schema(name="password")
	private String password;
	@NotNull(message="role cannot be null")
	@Schema(name="role")
	private String role;
}
