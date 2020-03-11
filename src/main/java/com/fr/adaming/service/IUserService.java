package com.fr.adaming.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.fr.adaming.entity.User;

public interface IUserService {

	//create
	/**
	 * @param user the given entity
	 * @return null if there is a problem, else the user after creating
	 */
	public User create(User user);
	
	//readAll
	
	/**
	 * @return may be empty
	 */
	public List<User> readAll();
	
	//readById
	/**
	 * @param id the given id
	 * @return the user or null
	 */
	public User readById(int id);
	
	//readByEmail
	/**
	 * @param email the given email
	 * @return the user or null
	 */
	public User readByEmail(String email);
	
	//update
	/**
	 * @param user the given user
	 * @return false if not found user by id, true if SUCCESS
	 */
	public boolean update(User user);
	
	//delete
	public boolean delete(User user);
	
	//deleteById
	public boolean deleteById(int id);
	
}
