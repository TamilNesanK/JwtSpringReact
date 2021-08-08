package com.jwtreact.jwtreactintegration.model;

import lombok.Data;
@Data
public class UserResponse {

	private String token;
	private String note;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getNote() {
		return note;
	}

	public UserResponse(String token, String note) {

		this.token = token;
		this.note = note;
	}

	public UserResponse() {
	}

	public void setNote(String note) {
		this.note = note;
	}

}
