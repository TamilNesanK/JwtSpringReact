package com.jwtreact.jwtreactintegration.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtreact.jwtreactintegration.model.User;
import com.jwtreact.jwtreactintegration.model.UserRequest;
import com.jwtreact.jwtreactintegration.model.UserResponse;
import com.jwtreact.jwtreactintegration.service.IUserService;
import com.jwtreact.jwtreactintegration.util.JwtUtil;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private IUserService service;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/signUp")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		Integer id = service.saveUser(user);
		return ResponseEntity.ok("User saved with id" + id);
	}

	@PostMapping("/login")
	public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest userRequest)
	{

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));

		String token = jwtUtil.generateToken(userRequest.getUsername());

		return ResponseEntity.ok(new UserResponse(token, "token generated successfully"));
	}

	@PostMapping("/welcome")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('EMP')")
	public ResponseEntity<String> accessUserData(Principal p) {
		return ResponseEntity.ok("Hello user:" + p.getName());
	}

	@PostMapping("/hi")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<String> hi() {
		return ResponseEntity.ok("Hi user");
	}


}
