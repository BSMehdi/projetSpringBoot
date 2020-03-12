package com.fr.adaming.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.IUserDao;
import com.fr.adaming.entity.User;
import com.fr.adaming.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;

	@Override
	public User create(User user) {
		try {
			if(user == null || dao.existsByEmail(user.getEmail())) {
				return null;
			}
			return dao.save(user);
		}catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> readAll() {
		return dao.findAll();
	}

	@Override
	public User readById(int id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public User readByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public boolean update(User user) {

		if (user == null || !dao.existsById(user.getId()) || dao.existsByEmail(user.getEmail())) {
			// l'utilisateur n'existe pas
			return false;
		} else {
			System.out.println("DEBUG update user :");
			dao.save(user);
			return true;
		}

	}

	@Override
	public boolean delete(User user) {
//		if(user == null || !dao.existsById(user.getId())) {
//			return false;
//		}
//		dao.delete(user);
//		return true;
		
		try {
			dao.delete(user);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		if(!dao.existsById(id)) {
			return false;
		}
		dao.deleteById(id);
		return true;
	}

}
