package com.platformcommons.StudentManagementSystem.Exception;

import lombok.Data;

@Data
public class ApiResponse {

  
	public ApiResponse(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}
	private String message;
    private boolean success;
    
   
}
