package com.online_cab_booking.ride.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import com.online_cab_booking.ride.dto.LoginRequest;
import com.online_cab_booking.ride.entity.Login;
import com.online_cab_booking.ride.security.JwtUtil;
import com.online_cab_booking.ride.service.LoginAttemptService;
import com.online_cab_booking.ride.serviceimpl.LoginAttemptServiceImpl;
import com.online_cab_booking.ride.serviceimpl.LoginService;

@RestController
@RequestMapping("api")
public class AuthController {

	@Autowired private AuthenticationManager authMgr;
	  @Autowired private LoginService userSvc;
	  @Autowired private JwtUtil jwtUtil;
	  @Autowired private LoginAttemptServiceImpl attemptSvc;
	private ExecutorService pool = Executors.newCachedThreadPool();

	  @PostMapping("/login")
	  public ResponseEntity<?> login(@RequestBody LoginRequest req) {
	    Future<ResponseEntity<?>> future = pool.submit(() -> {
	      try {
	        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword());
	        Authentication auth = authMgr.authenticate(authReq);
	        Login user = userSvc.findByEmail(req.getEmail());
	        attemptSvc.loginSucceeded(user);
	        String token = jwtUtil.generateToken(user);
	        return ResponseEntity.ok(Map.of("token", token));
	      } catch (BadCredentialsException | LockedException ex) {
	        Login user = userSvc.findByEmail(req.getEmail());
	        if (user != null) attemptSvc.loginFailed(user);
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	          .body(Map.of("error", ex.getMessage()));
	      }
	    });
	    try { return future.get(); }
	    catch (Exception e) { return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); }
	  }

}
