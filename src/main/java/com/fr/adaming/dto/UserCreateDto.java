package com.fr.adaming.dto;

import lombok.Data;

@Data
public class UserCreateDto {

	private String mail;

	private String passsword;
	
	private String lastName;
	
	private String firstName;
	
	private boolean activated;
}
