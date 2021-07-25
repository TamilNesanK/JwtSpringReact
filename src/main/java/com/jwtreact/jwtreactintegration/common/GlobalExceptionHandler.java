package com.jwtreact.jwtreactintegration.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ExceptionHandler
	public ResponseEntity<APIResponse> handleAccessDeniedException(AccessDeniedException e) {

		APIResponse api = new APIResponse();
		api.setStatus(HttpStatus.UNAUTHORIZED.value());
		return ResponseEntity.status(api.getStatus()).body(api);

	}
}
