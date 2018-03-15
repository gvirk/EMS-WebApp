package com.jarq.login.service;

import java.util.List;

import com.jarq.login.entity.User;

public interface UserService {
	
	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(int theId);

	public void deleteUser(int theId);

	public List<User> searchUsers(String theSearchName);

}
