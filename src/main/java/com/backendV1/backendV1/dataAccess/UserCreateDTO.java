package com.backendV1.backendV1.dataAccess;


import lombok.Data;

@Data
public class UserCreateDTO {
	
	@Size
	private String firstName;
	
	private String lastName;
	

}
