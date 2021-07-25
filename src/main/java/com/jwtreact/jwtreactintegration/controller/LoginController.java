package com.jwtreact.jwtreactintegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jwtreact.jwtreactintegration.common.APIResponse;
import com.jwtreact.jwtreactintegration.dto.LoginRequestDTO;
import com.jwtreact.jwtreactintegration.dto.SignUpRequestDTO;
import com.jwtreact.jwtreactintegration.service.LoginService;

@RestController

@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/signUp")
	public ResponseEntity<APIResponse> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO) {

		APIResponse apiResponse = loginService.signUp(signUpRequestDTO);

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	@PostMapping("/login")
	public ResponseEntity<APIResponse> login(@RequestBody LoginRequestDTO loginRequestDTO) {

		APIResponse apiResponse = loginService.login(loginRequestDTO);

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	@GetMapping("/privateApi")
	public ResponseEntity<APIResponse> privateApi(@RequestHeader(name = "authorization", defaultValue = "") String auth)
			throws Exception {

		APIResponse apiResponse = new APIResponse();
		apiResponse.setData("It is Working");

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}
}
