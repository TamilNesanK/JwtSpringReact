package com.jwtreact.jwtreactintegration.service;

import com.jwtreact.jwtreactintegration.model.User;

public interface IUserService {

	public Integer saveUser(User user);

	public User findByUsername(String username);
}
