package com.fr.adaming.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fr.adaming.dto.ResponseDto;
import com.fr.adaming.dto.UserCreateDto;
import com.fr.adaming.dto.UserDto;

@RequestMapping(path = "/user")
public interface IGestionUserController {

	// SuperAdmin
	@PostMapping
	public ResponseEntity<ResponseDto> create(@RequestBody UserCreateDto dto);

	@GetMapping
	public ResponseEntity<ResponseDto> readById(@RequestParam(name = "id", required = false) int id);
	
	@PutMapping
	public ResponseEntity<ResponseDto> update(@RequestBody UserDto dto);
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<ResponseDto> deleteById(@PathVariable(name = "id") int id);
}
