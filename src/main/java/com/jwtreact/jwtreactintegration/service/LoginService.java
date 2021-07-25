package com.jwtreact.jwtreactintegration.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwtreact.jwtreactintegration.common.APIResponse;
import com.jwtreact.jwtreactintegration.dto.LoginRequestDTO;
import com.jwtreact.jwtreactintegration.dto.SignUpRequestDTO;
import com.jwtreact.jwtreactintegration.entity.User;
import com.jwtreact.jwtreactintegration.repo.UserRepository;
import com.jwtreact.jwtreactintegration.util.JwtUtils;

@Service
public class LoginService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtUtils jwtUtils;
	public APIResponse signUp(SignUpRequestDTO signUpRequestDTO) {

		APIResponse apiResponse = new APIResponse();
		User user = new User();
		user.setName(signUpRequestDTO.getName());
		user.setEmailId(signUpRequestDTO.getEmailId());
		user.setPassword(signUpRequestDTO.getPassword());
		user.setIsActive(Boolean.TRUE);
		user = userRepository.save(user);
		apiResponse.setData(user);
		return apiResponse;
	}

	public APIResponse login(LoginRequestDTO loginRequestDTO) {

		APIResponse apiResponse = new APIResponse();
		User user = new User();
		user = userRepository.findOneByEmailIdIgnoreCaseAndPassword(loginRequestDTO.getEmailId(),
				loginRequestDTO.getPassword());

		if (user == null) {
			apiResponse.setData("Login Failed");
			return apiResponse;
		} 
		String token = jwtUtils.generateToken(user);
		Map<String, Object> claimsMap = new HashMap<>();
		claimsMap.put("accessToken", token);

		apiResponse.setData(claimsMap);
		return apiResponse;
	}

}
