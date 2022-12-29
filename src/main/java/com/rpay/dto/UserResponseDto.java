package com.rpay.dto;

import org.springframework.stereotype.Component;

@Component
public class UserResponseDto {
	
	private String statusCode;
	
	private String description;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
