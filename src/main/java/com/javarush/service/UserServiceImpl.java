package com.javarush.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javarush.dao.UserDao;
import com.javarush.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Transactional
	public void add(User user) {
		userDao.add(user);
	}

	@Transactional
	public void edit(User user) {
		userDao.edit(user);
	}

	@Transactional
	public void delete(int userId) {
		userDao.delete(userId);
	}

	@Transactional
	public User getUser(int userId) {
		return userDao.getUser(userId);
	}

	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
}
