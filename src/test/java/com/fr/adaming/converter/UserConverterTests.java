package com.fr.adaming.converter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fr.adaming.dto.UserCreateDto;
import com.fr.adaming.entity.User;

@SpringBootTest
public class UserConverterTests {

	
	@Test
	public void testConvertingUserCreateDtoToUser() {
		//Préparer les inputs
		UserCreateDto dto = new UserCreateDto();
		dto.setActivated(true);
		dto.setFirstName("Chuck");
		dto.setLastName("Norris");
		dto.setMail("email@gmail.com");
		dto.setPasssword("0000");
		
		//Invoquer l'appli
		
		User returnedUser = UserConverter.convertUserCreateDtoToUser(dto);
		System.out.println("DEBUG user : " + returnedUser);
		
		//vérifier le résultat
		assertNotNull(returnedUser);
		assertThat(returnedUser).hasFieldOrPropertyWithValue("email", dto.getMail());
		assertThat(returnedUser).hasFieldOrPropertyWithValue("activated", dto.isActivated());
		assertThat(returnedUser).hasFieldOrPropertyWithValue("nom", dto.getLastName());
		assertThat(returnedUser).hasFieldOrPropertyWithValue("prenom", dto.getFirstName());
		assertThat(returnedUser).hasFieldOrPropertyWithValue("pwd", dto.getPasssword());
	}
	
	
	@Test
	public void testConvertingNullDtoToUser_shouldReturnNullUser() {
		assertNull(UserConverter.convertUserCreateDtoToUser(null));
	}
	
}
