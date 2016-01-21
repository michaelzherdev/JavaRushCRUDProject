package com.javarush.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javarush.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void edit(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void delete(int userId) {
		sessionFactory.getCurrentSession().delete(getUser(userId));
	}

	@Override
	public User getUser(int userId) {
		return (User) sessionFactory.getCurrentSession().get(User.class, userId);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> result = (List<User>) sessionFactory.getCurrentSession().createQuery("from User").list();
		return result;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
