package com.fr.adaming.service.impl;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.fr.adaming.dao.IUserDao;
import com.fr.adaming.entity.User;
import com.fr.adaming.service.IUserService;

@SpringBootTest
public class UserServiceImplTests {

	@Autowired
	private IUserService service;
	
	@Autowired
	private IUserDao dao;
	
	private static final String EMAIL= "email@gmail.com";
	
	
	@Sql(statements = "delete from user where email = 'email@gmail.com'", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	@Test
	@DisplayName("Création d'un utilisateur valide")
	public void testCreatingValidUser_shouldReturnUserWithId() {
		//Préparer les inputs
		User userInput = new User("nomUser1", "prenomUser1", "email@gmail.com", "azerty");
		assertEquals(0, userInput.getId());
		
		//invoquer l'appli
		User returnedUser = service.create(userInput);
		
		//vérifier le retour
		assertTrue(returnedUser.getId() > 0);
		
		assertTrue(dao.existsById(returnedUser.getId()));
	}
	
	@Sql(statements = "insert into user (email, pwd, activated) values ('email@gmail.com', 'xx', false)", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "delete from user where email =  '"+EMAIL+"'", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	@Test
	@DisplayName("Création d'un utilisateur avec un email existant")
	public void testCreatingUserWithExistingEmail_shouldReturnNull() {
		
		assertNull(service.create(new User("", "", "email@gmail.com", "")));
	}
	
	@Test
	@DisplayName("Création d'un utilisateur avec un email = NULL")
	public void testCreatingUserWithNullEmail_shouldReturnNull() {
		assertNull(service.create(new User("xx", "xx", null, "xx")));
	}
	
	@Test
	@DisplayName("Création d'un utilisateur avec un mot de passe = NULL")
	public void testCreatingUserWithNullPwd_shouldReturnNull() {
		assertNull(service.create(new User("xx", "xx", "xx", null)));
	}

	@Sql(statements = "insert into user (id, email, pwd, activated) values (555, '"+EMAIL+"', 'xx', false)", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "delete from user where email =  '"+EMAIL+"'", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	@Test
	@DisplayName("Création d'un utilisateur avec un ID existant")
	public void testCreatingUserWithExistingId_shouldReturnNull() {
		User user = new User();
		user.setId(555);
		assertNull(service.create(user));
	}
	
	@Test
	@DisplayName("Création d'un utilisateur = NULL")
	public void testCreatingNullUser_shouldReturnNull() {
		assertNull(service.create(null));
	}
}
