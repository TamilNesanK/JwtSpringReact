package com.jwtreact.jwtreactintegration.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.jwtreact.jwtreactintegration.util.JwtUtils;



@Component
public class JwtInterceptor implements HandlerInterceptor {
	@Autowired
	private JwtUtils jwtUtils;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String uri = request.getRequestURI();
		String authorization = request.getHeader("authorization");
		if (uri.contains("login") || uri.contains("signUp")) {

		} else {
			jwtUtils.verify(authorization);
		}

		return HandlerInterceptor.super.preHandle(request, response, handler);
	}


}
