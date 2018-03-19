package com.jarq.login.dao;

import java.util.List;

import com.jarq.login.entity.JanuaryExpends;
import com.jarq.login.entity.User;

public interface UserDAO {

	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(int theId);

	public void deleteUser(int theId);

	public List<User> searchUsers(String theSearchName);

	public List<JanuaryExpends> getJanuaryExpends();

	public Object[] getSumJan();

	public void deleteRow(int theId);

	public JanuaryExpends getExpJan(int theId);

	public void saveExpendsJan(JanuaryExpends theExpends);

	public void saveNewExpendsJan(JanuaryExpends theJanuaryExpends);

	public List<User> getUser();
}
