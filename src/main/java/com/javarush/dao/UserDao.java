package com.javarush.dao;

import java.util.List;

import com.javarush.model.User;

public interface UserDao {
	
	public void add(User user);
	
	public void edit(User user);
	
	public void delete(int userId);
	
	public User getUser(int userId);
	
	public List<User> getAllUsers();

}
