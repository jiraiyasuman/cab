package com.online_cab_booking.ride.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.online_cab_booking.ride.serviceimpl.LoginService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{

	
	private JwtUtil jwtUtil;
	private LoginService loginService;
	
	@Autowired
	public JwtFilter(JwtUtil jwtUtil, LoginService loginService) {
		super();
		this.jwtUtil = jwtUtil;
		this.loginService = loginService;
	}

	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
	    String auth = req.getHeader("Authorization");
	    if (auth != null && auth.startsWith("Bearer ")) {
	        String token = auth.substring(7);
	        if (jwtUtil.validateToken(token)) {
	            String email = jwtUtil.getUsername(token);

	            // ✅ FIXED HERE
	            UserDetails user = loginService.loadUserByUsername(email);

	            UsernamePasswordAuthenticationToken authentication =
	                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

	            SecurityContextHolder.getContext().setAuthentication(authentication);
	        }
	    }
	    chain.doFilter(req, res);
	  }
	
}
