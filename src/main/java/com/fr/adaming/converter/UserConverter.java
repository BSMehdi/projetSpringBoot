package com.fr.adaming.converter;

import com.fr.adaming.dto.UserCreateDto;
import com.fr.adaming.dto.UserDto;
import com.fr.adaming.entity.User;

public class UserConverter {

	public static User convertUserCreateDtoToUser(UserCreateDto dto) {
		if (dto == null) {
			return null;
		}

		User user = new User();

		user.setEmail(dto.getMail());
		user.setNom(dto.getLastName());
		user.setPrenom(dto.getFirstName());
		user.setActivated(dto.isActivated());
		user.setPwd(dto.getPasssword());

		return user;

	}
	
	public static UserCreateDto convertUserToUserCreateDto(User user) {
		if(user == null) {
			return null;
		}
		
		UserCreateDto dto = new UserCreateDto();
		
		dto.setActivated(user.isActivated());
		dto.setFirstName(user.getPrenom());
		dto.setLastName(user.getNom());
		dto.setMail(user.getEmail());
		dto.setPasssword(user.getPwd());
		
		return dto;
	}

	public static User convertUserCreateDtoToUser(UserDto dto) {
		if (dto == null) {
			return null;
		}

		User user = new User();

		user.setEmail(dto.getMail());
		user.setNom(dto.getLastName());
		user.setPrenom(dto.getFirstName());
		user.setActivated(dto.isActivated());
		user.setPwd(dto.getPasssword());
		user.setId(dto.getId());

		return user;

	}

	public static UserDto convertUserToUserDto(User user) {
		if(user == null) {
			return null;
		}
		
		UserDto dto = new UserDto();
		
		dto.setActivated(user.isActivated());
		dto.setFirstName(user.getPrenom());
		dto.setLastName(user.getNom());
		dto.setMail(user.getEmail());
		dto.setPasssword(user.getPwd());
		dto.setId(user.getId());
		
		return dto;
	}
}
