package com.fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.converter.UserConverter;
import com.fr.adaming.dto.ResponseDto;
import com.fr.adaming.dto.UserCreateDto;
import com.fr.adaming.dto.UserDto;
import com.fr.adaming.service.IUserService;

@RestController
public class GestionUserController implements IGestionUserController {

	@Autowired
	private IUserService service;

	// SuperAdmin
	@Override
	public ResponseEntity<ResponseDto> create(UserCreateDto dto) {
		ResponseDto resp = null;

		UserCreateDto dtoResp = UserConverter
				.convertUserToUserCreateDto(service.create(UserConverter.convertUserCreateDtoToUser(dto)));

		if (dtoResp != null) {
			// Success
			resp = new ResponseDto(false, "SUCCESS", dtoResp);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		} else {
			// fail
			resp = new ResponseDto(true, "FAIL", null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
		}
	}

	@Override
	public ResponseEntity<ResponseDto> readById(int id) { // /user?id=

		UserDto u = UserConverter.convertUserToUserDto(service.readById(id));
		ResponseDto resp = null;

		if (u != null) {
			// SUCCESS
			resp = new ResponseDto(false, "SUCCESS", u);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		} else {
			// FAIL
			resp = new ResponseDto(true, "FAIL", null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);

		}
	}

	@Override
	public ResponseEntity<ResponseDto> update(UserDto dto) {
		
		boolean result = service.update(UserConverter.convertUserCreateDtoToUser(dto));
		ResponseDto resp = null;
		
		if(result){

			resp = new ResponseDto(false, "SUCCESS", null);
			
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}else {

			resp = new ResponseDto(true, "FAIL", null);
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
			
		}
	}

	@Override
	public ResponseEntity<ResponseDto> deleteById(int id) {
		
		boolean result = service.deleteById(id);
		ResponseDto resp = null;
		
		if(result){

			resp = new ResponseDto(false, "SUCCESS", null);
			
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}else {

			resp = new ResponseDto(true, "FAIL", null);
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
			
		}
	}
	
	
	
	
}
