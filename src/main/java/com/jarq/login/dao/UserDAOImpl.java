package com.jarq.login.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.jarq.login.entity.AprilExpends;
import com.jarq.login.entity.AugustExpends;
import com.jarq.login.entity.DecemberExpends;
import com.jarq.login.entity.FebruaryExpends;
import com.jarq.login.entity.JanuaryExpends;
import com.jarq.login.entity.JulyExpends;
import com.jarq.login.entity.JuneExpends;
import com.jarq.login.entity.MarchExpends;
import com.jarq.login.entity.MayExpends;
import com.jarq.login.entity.NovemberExpends;
import com.jarq.login.entity.OctoberExpends;
import com.jarq.login.entity.SeptemberExpends;
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
			theQuery = currentSession.createQuery(
					"from User where lower(username) like :theName or lower(firstName) like :theName or lower(lastName) like :theName or lower(email) like :theName",
					User.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		}

		else {

			// theSearchName is empty ... so just get all users
			theQuery = currentSession.createQuery("from User", User.class);
		}

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
		Object[] sumJan = (Object[]) theQuery.getSingleResult();

		// return the results
		return sumJan;
	}

	@Override
	public void deleteRowJan(int theId) {

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

	/*
	 * FEBRUARY
	 */

	@Override
	public List<FebruaryExpends> getFebruaryExpends() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<FebruaryExpends> theQuery = currentSession.createQuery("from FebruaryExpends", FebruaryExpends.class);

		// execute query and get result list
		List<FebruaryExpends> februaryExp = theQuery.getResultList();

		// return the results
		return februaryExp;
	}

	@Override
	public Object[] getSumFeb() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		String sql = "SELECT SUM(e.eating), SUM(e.mobile), SUM(e.flat), SUM(e.fuel), SUM(e.tickets), SUM(e.payment), SUM(e.other) FROM FebruaryExpends e";
		Query theQuery = currentSession.createQuery(sql);

		// execute query and get result list
		Object[] sumFeb = (Object[]) theQuery.getSingleResult();

		// return the results
		return sumFeb;
	}

	@Override
	public FebruaryExpends getExpFeb(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		FebruaryExpends theExpFeb = currentSession.get(FebruaryExpends.class, theId);

		return theExpFeb;
	}

	@Override
	public void deleteRowFeb(int theId) {

		// get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from FebruaryExpends where id=:RowId");
		theQuery.setParameter("RowId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public void saveExpendsFeb(FebruaryExpends theExpends) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save or update expends finally
		currentSession.saveOrUpdate(theExpends);

	}

	/*
	 * MARCH
	 */

	@Override
	public List<MarchExpends> getMarchExpends() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<MarchExpends> theQuery = currentSession.createQuery("from MarchExpends", MarchExpends.class);

		// execute query and get result list
		List<MarchExpends> marchExp = theQuery.getResultList();

		// return the results
		return marchExp;
	}

	@Override
	public Object[] getSumMar() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		String sql = "SELECT SUM(e.eating), SUM(e.mobile), SUM(e.flat), SUM(e.fuel), SUM(e.tickets), SUM(e.payment), SUM(e.other) FROM MarchExpends e";
		Query theQuery = currentSession.createQuery(sql);

		// execute query and get result list
		Object[] sumMar = (Object[]) theQuery.getSingleResult();

		// return the results
		return sumMar;
	}

	@Override
	public MarchExpends getExpMar(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		MarchExpends theExpMar = currentSession.get(MarchExpends.class, theId);

		return theExpMar;
	}

	@Override
	public void deleteRowMar(int theId) {

		// get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from MarchExpends where id=:RowId");
		theQuery.setParameter("RowId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public void saveExpendsMar(MarchExpends theExpends) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save or update expends finally
		currentSession.saveOrUpdate(theExpends);

	}

	/*
	 * APRIL
	 */

	@Override
	public List<AprilExpends> getAprilExpends() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<AprilExpends> theQuery = currentSession.createQuery("from AprilExpends", AprilExpends.class);

		// execute query and get result list
		List<AprilExpends> aprilExp = theQuery.getResultList();

		// return the results
		return aprilExp;
	}

	@Override
	public Object[] getSumApr() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		String sql = "SELECT SUM(e.eating), SUM(e.mobile), SUM(e.flat), SUM(e.fuel), SUM(e.tickets), SUM(e.payment), SUM(e.other) FROM AprilExpends e";
		Query theQuery = currentSession.createQuery(sql);

		// execute query and get result list
		Object[] sumApr = (Object[]) theQuery.getSingleResult();

		// return the results
		return sumApr;
	}

	@Override
	public AprilExpends getExpApr(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		AprilExpends theExpApr = currentSession.get(AprilExpends.class, theId);

		return theExpApr;
	}

	@Override
	public void deleteRowApr(int theId) {

		// get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from AprilExpends where id=:RowId");
		theQuery.setParameter("RowId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public void saveExpendsApr(AprilExpends theExpends) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save or update expends finally
		currentSession.saveOrUpdate(theExpends);

	}

	/*
	 * MAY
	 */

	@Override
	public List<MayExpends> getMayExpends() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<MayExpends> theQuery = currentSession.createQuery("from MayExpends", MayExpends.class);

		// execute query and get result list
		List<MayExpends> mayExp = theQuery.getResultList();

		// return the results
		return mayExp;
	}

	@Override
	public Object[] getSumMay() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		String sql = "SELECT SUM(e.eating), SUM(e.mobile), SUM(e.flat), SUM(e.fuel), SUM(e.tickets), SUM(e.payment), SUM(e.other) FROM MayExpends e";
		Query theQuery = currentSession.createQuery(sql);

		// execute query and get result list
		Object[] sumMay = (Object[]) theQuery.getSingleResult();

		// return the results
		return sumMay;
	}

	@Override
	public MayExpends getExpMay(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		MayExpends theExpMay = currentSession.get(MayExpends.class, theId);

		return theExpMay;
	}

	@Override
	public void deleteRowMay(int theId) {

		// get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from MayExpends where id=:RowId");
		theQuery.setParameter("RowId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public void saveExpendsMay(MayExpends theExpends) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save or update expends finally
		currentSession.saveOrUpdate(theExpends);

	}
	
	/*
	 * JUNE
	 */

	@Override
	public List<JuneExpends> getJuneExpends() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<JuneExpends> theQuery = currentSession.createQuery("from JuneExpends", JuneExpends.class);

		// execute query and get result list
		List<JuneExpends> juneExp = theQuery.getResultList();

		// return the results
		return juneExp;
	}

	@Override
	public Object[] getSumJun() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		String sql = "SELECT SUM(e.eating), SUM(e.mobile), SUM(e.flat), SUM(e.fuel), SUM(e.tickets), SUM(e.payment), SUM(e.other) FROM JuneExpends e";
		Query theQuery = currentSession.createQuery(sql);

		// execute query and get result list
		Object[] sumJun = (Object[]) theQuery.getSingleResult();

		// return the results
		return sumJun;
	}

	@Override
	public JuneExpends getExpJun(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		JuneExpends theExpJun = currentSession.get(JuneExpends.class, theId);

		return theExpJun;
	}

	@Override
	public void deleteRowJun(int theId) {

		// get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from JuneExpends where id=:RowId");
		theQuery.setParameter("RowId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public void saveExpendsJun(JuneExpends theExpends) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save or update expends finally
		currentSession.saveOrUpdate(theExpends);

	}
	
	/*
	 * JULY
	 */

	@Override
	public List<JulyExpends> getJulyExpends() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<JulyExpends> theQuery = currentSession.createQuery("from JulyExpends", JulyExpends.class);

		// execute query and get result list
		List<JulyExpends> julyExp = theQuery.getResultList();

		// return the results
		return julyExp;
	}

	@Override
	public Object[] getSumJul() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		String sql = "SELECT SUM(e.eating), SUM(e.mobile), SUM(e.flat), SUM(e.fuel), SUM(e.tickets), SUM(e.payment), SUM(e.other) FROM JulyExpends e";
		Query theQuery = currentSession.createQuery(sql);

		// execute query and get result list
		Object[] sumJul = (Object[]) theQuery.getSingleResult();

		// return the results
		return sumJul;
	}

	@Override
	public JulyExpends getExpJul(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		JulyExpends theExpJul = currentSession.get(JulyExpends.class, theId);

		return theExpJul;
	}

	@Override
	public void deleteRowJul(int theId) {

		// get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from JulyExpends where id=:RowId");
		theQuery.setParameter("RowId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public void saveExpendsJul(JulyExpends theExpends) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save or update expends finally
		currentSession.saveOrUpdate(theExpends);

	}
	
	/*
	 * AUGUST
	 */

	@Override
	public List<AugustExpends> getAugustExpends() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<AugustExpends> theQuery = currentSession.createQuery("from AugustExpends", AugustExpends.class);

		// execute query and get result list
		List<AugustExpends> augustExp = theQuery.getResultList();

		// return the results
		return augustExp;
	}

	@Override
	public Object[] getSumAug() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		String sql = "SELECT SUM(e.eating), SUM(e.mobile), SUM(e.flat), SUM(e.fuel), SUM(e.tickets), SUM(e.payment), SUM(e.other) FROM AugustExpends e";
		Query theQuery = currentSession.createQuery(sql);

		// execute query and get result list
		Object[] sumAug = (Object[]) theQuery.getSingleResult();

		// return the results
		return sumAug;
	}

	@Override
	public AugustExpends getExpAug(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		AugustExpends theExpAug = currentSession.get(AugustExpends.class, theId);

		return theExpAug;
	}

	@Override
	public void deleteRowAug(int theId) {

		// get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from AugustExpends where id=:RowId");
		theQuery.setParameter("RowId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public void saveExpendsAug(AugustExpends theExpends) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save or update expends finally
		currentSession.saveOrUpdate(theExpends);

	}
	
	/*
	 * SEPTEMBER
	 */

	@Override
	public List<SeptemberExpends> getSeptemberExpends() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<SeptemberExpends> theQuery = currentSession.createQuery("from SeptemberExpends", SeptemberExpends.class);

		// execute query and get result list
		List<SeptemberExpends> septemberExp = theQuery.getResultList();

		// return the results
		return septemberExp;
	}

	@Override
	public Object[] getSumSep() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		String sql = "SELECT SUM(e.eating), SUM(e.mobile), SUM(e.flat), SUM(e.fuel), SUM(e.tickets), SUM(e.payment), SUM(e.other) FROM SeptemberExpends e";
		Query theQuery = currentSession.createQuery(sql);

		// execute query and get result list
		Object[] sumSep = (Object[]) theQuery.getSingleResult();

		// return the results
		return sumSep;
	}

	@Override
	public SeptemberExpends getExpSep(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		SeptemberExpends theExpSep = currentSession.get(SeptemberExpends.class, theId);

		return theExpSep;
	}

	@Override
	public void deleteRowSep(int theId) {

		// get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from SeptemberExpends where id=:RowId");
		theQuery.setParameter("RowId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public void saveExpendsSep(SeptemberExpends theExpends) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save or update expends finally
		currentSession.saveOrUpdate(theExpends);

	}

	/*
	 * OCTOBER
	 */

	@Override
	public List<OctoberExpends> getOctoberExpends() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<OctoberExpends> theQuery = currentSession.createQuery("from OctoberExpends", OctoberExpends.class);

		// execute query and get result list
		List<OctoberExpends> octoberExp = theQuery.getResultList();

		// return the results
		return octoberExp;
	}

	@Override
	public Object[] getSumOct() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		String sql = "SELECT SUM(e.eating), SUM(e.mobile), SUM(e.flat), SUM(e.fuel), SUM(e.tickets), SUM(e.payment), SUM(e.other) FROM OctoberExpends e";
		Query theQuery = currentSession.createQuery(sql);

		// execute query and get result list
		Object[] sumOct = (Object[]) theQuery.getSingleResult();

		// return the results
		return sumOct;
	}

	@Override
	public OctoberExpends getExpOct(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		OctoberExpends theExpOct = currentSession.get(OctoberExpends.class, theId);

		return theExpOct;
	}

	@Override
	public void deleteRowOct(int theId) {

		// get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from OctoberExpends where id=:RowId");
		theQuery.setParameter("RowId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public void saveExpendsOct(OctoberExpends theExpends) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save or update expends finally
		currentSession.saveOrUpdate(theExpends);

	}
	
	/*
	 * NOVEMBER
	 */

	@Override
	public List<NovemberExpends> getNovemberExpends() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<NovemberExpends> theQuery = currentSession.createQuery("from NovemberExpends", NovemberExpends.class);

		// execute query and get result list
		List<NovemberExpends> novemberExp = theQuery.getResultList();

		// return the results
		return novemberExp;
	}

	@Override
	public Object[] getSumNov() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		String sql = "SELECT SUM(e.eating), SUM(e.mobile), SUM(e.flat), SUM(e.fuel), SUM(e.tickets), SUM(e.payment), SUM(e.other) FROM NovemberExpends e";
		Query theQuery = currentSession.createQuery(sql);

		// execute query and get result list
		Object[] sumNov = (Object[]) theQuery.getSingleResult();

		// return the results
		return sumNov;
	}

	@Override
	public NovemberExpends getExpNov(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		NovemberExpends theExpNov = currentSession.get(NovemberExpends.class, theId);

		return theExpNov;
	}

	@Override
	public void deleteRowNov(int theId) {

		// get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from NovemberExpends where id=:RowId");
		theQuery.setParameter("RowId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public void saveExpendsNov(NovemberExpends theExpends) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save or update expends finally
		currentSession.saveOrUpdate(theExpends);

	}
	
	/*
	 * DECEMBER
	 */

	@Override
	public List<DecemberExpends> getDecemberExpends() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<DecemberExpends> theQuery = currentSession.createQuery("from DecemberExpends", DecemberExpends.class);

		// execute query and get result list
		List<DecemberExpends> decemberExp = theQuery.getResultList();

		// return the results
		return decemberExp;
	}

	@Override
	public Object[] getSumDec() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		String sql = "SELECT SUM(e.eating), SUM(e.mobile), SUM(e.flat), SUM(e.fuel), SUM(e.tickets), SUM(e.payment), SUM(e.other) FROM DecemberExpends e";
		Query theQuery = currentSession.createQuery(sql);

		// execute query and get result list
		Object[] sumDec = (Object[]) theQuery.getSingleResult();

		// return the results
		return sumDec;
	}

	@Override
	public DecemberExpends getExpDec(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		DecemberExpends theExpDec = currentSession.get(DecemberExpends.class, theId);

		return theExpDec;
	}

	@Override
	public void deleteRowDec(int theId) {

		// get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from DecemberExpends where id=:RowId");
		theQuery.setParameter("RowId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public void saveExpendsDec(DecemberExpends theExpends) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save or update expends finally
		currentSession.saveOrUpdate(theExpends);

	}
}
