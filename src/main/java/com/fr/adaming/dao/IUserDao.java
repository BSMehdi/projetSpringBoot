package com.fr.adaming.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fr.adaming.entity.User;

public interface IUserDao extends JpaRepository<User, Integer> {

	public User findByEmail(String email);
	
	public boolean existsByEmail(String email);

}
