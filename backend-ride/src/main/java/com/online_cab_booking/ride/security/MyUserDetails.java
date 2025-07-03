package com.online_cab_booking.ride.security;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.online_cab_booking.ride.entity.Login;

public class MyUserDetails implements UserDetails{

	private Login login;
	public MyUserDetails() {
		super();
	}

	public MyUserDetails(Login login) {
		super();
		this.login = login;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return login.getPassword();
	}

	@Override
	public String getUsername() {
		return login.getEmail();
	}

	public Login getUserDtls() {
		return login;
	}

	public void setUserDtls(Login userDtls) {
		this.login = userDtls;
	}

	
}
