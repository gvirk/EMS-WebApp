package com.jarq.login.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.jarq.login.entity.JanuaryExpends;
import com.jarq.login.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	// need to inject the session factory

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getUsers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<User> theQuery = currentSession.createQuery("from User", User.class);

		// execute query and get result list
		List<User> users = theQuery.getResultList();

		// return the results
		return users;
	}

	@Override
	public void saveUser(User theUser) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save or update user finally
		currentSession.saveOrUpdate(theUser);

	}

	@Override
	public User getUser(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		User theUser = currentSession.get(User.class, theId);
		
		return theUser;
	}

	@Override
	public void deleteUser(int theId) {
		
		// get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from User where id=:UserId");
		theQuery.setParameter("UserId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public List<User> searchUsers(String theSearchName) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		// only search by username if theSearchName is not empty
		
		if (theSearchName != null && theSearchName.trim().length() > 0) { 
			
			// search for username or firstName or lastName or email... case insensitive 
			theQuery =currentSession.createQuery("from User where lower(username) like :theName or lower(firstName) like :theName or lower(lastName) like :theName or lower(email) like :theName", User.class); 
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%"); } 
		
		else { 
			
			// theSearchName is empty ... so just get all users 
			theQuery =currentSession.createQuery("from User", User.class); } 
		
			// execute query and get result list 
			List<User> users = theQuery.getResultList(); 
			
			// return the results return customers;
			return users;
		
	}

	@Override
	public List<JanuaryExpends> getJanuaryExpends() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<JanuaryExpends> theQuery = currentSession.createQuery("from JanuaryExpends", JanuaryExpends.class);
	
		// execute query and get result list
		List<JanuaryExpends> januaryExp = theQuery.getResultList();

		// return the results
		return januaryExp;
	}

	@Override
	public Object[] getSumJan() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		String sql = "SELECT SUM(e.eating), SUM(e.mobile), SUM(e.flat), SUM(e.fuel), SUM(e.tickets), SUM(e.payment), SUM(e.other) FROM JanuaryExpends e";
		Query theQuery = currentSession.createQuery(sql);
		
		// execute query and get result list
		Object[] sumJan = (Object[])theQuery.getSingleResult();
		
		// return the results
		return sumJan;
	}

	@Override
	public void deleteRow(int theId) {

		// get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from JanuaryExpends where id=:RowId");
		theQuery.setParameter("RowId", theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public JanuaryExpends getExpJan(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		JanuaryExpends theExpJan = currentSession.get(JanuaryExpends.class, theId);
		
		return theExpJan;
	}

	@Override
	public void saveExpendsJan(JanuaryExpends theExpends) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save or update expends finally
		currentSession.saveOrUpdate(theExpends);
	}

	@Override
	public void saveNewExpendsJan(JanuaryExpends theJanuaryExpends) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save new expends finally
		currentSession.save(theJanuaryExpends);
	}

	@Override
	public List<User> getUser() {
		
		// get UserName from object from SpringSecurity
		String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query theQuery = currentSession.createQuery("SELECT e FROM User e WHERE e.username = :userName", User.class);
		theQuery.setParameter("userName", currentUser);
		theQuery.uniqueResult();
			
		// execute query and get result list
		List<User> theUser = theQuery.getResultList();
		
		return theUser;
	}

}
