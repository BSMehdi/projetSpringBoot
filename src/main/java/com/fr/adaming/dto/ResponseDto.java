package com.fr.adaming.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ResponseDto {

	private boolean isError; //default value = false
	
	private String message;
	
	private UserCreateDto body;
	
	
	
}
