package com.fr.adaming.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserCreateDto {

	//NonNull
	@NotNull
	@NotEmpty
	@NotBlank
	@Email
	private String mail;

	//NonNull
	@NotNull
	@NotBlank
	private String passsword;
	
	private String lastName;
	
	private String firstName;
	
	private boolean activated;
}
