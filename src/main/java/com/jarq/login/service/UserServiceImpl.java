package com.jarq.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jarq.login.dao.UserDAO;
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

@Service
public class UserServiceImpl implements UserService {

	// need to inject user dao
	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public void saveUser(User theUser) {

		userDAO.saveUser(theUser);

	}

	@Override
	@Transactional
	public User getUser(int theId) {

		return userDAO.getUser(theId);
	}

	@Override
	@Transactional
	public void deleteUser(int theId) {

		userDAO.deleteUser(theId);

	}

	@Override
	@Transactional
	public List<User> searchUsers(String theSearchName) {

		return userDAO.searchUsers(theSearchName);
	}

	@Override
	@Transactional
	public List<JanuaryExpends> getJanuaryExpends() {

		return userDAO.getJanuaryExpends();
	}

	@Override
	@Transactional
	public Object[] getSumJan() {

		return userDAO.getSumJan();
	}

	@Override
	@Transactional
	public void deleteRowJan(int theId) {

		userDAO.deleteRowJan(theId);
	}

	@Override
	@Transactional
	public JanuaryExpends getExpJan(int theId) {

		return userDAO.getExpJan(theId);
	}

	@Override
	@Transactional
	public void saveExpendsJan(JanuaryExpends theExpends) {

		userDAO.saveExpendsJan(theExpends);
	}

	@Override
	@Transactional
	public void saveNewExpendsJan(JanuaryExpends theJanuaryExpends) {

		userDAO.saveNewExpendsJan(theJanuaryExpends);
	}

	@Override
	@Transactional
	public List<User> getUser() {

		return userDAO.getUser();
	}

	/*
	 * FEBRUARY
	 */

	@Override
	@Transactional
	public List<FebruaryExpends> getFebruaryExpends() {

		return userDAO.getFebruaryExpends();
	}

	@Override
	@Transactional
	public Object[] getSumFeb() {

		return userDAO.getSumFeb();
	}

	@Override
	@Transactional
	public FebruaryExpends getExpFeb(int theId) {

		return userDAO.getExpFeb(theId);
	}

	@Override
	@Transactional
	public void deleteRowFeb(int theId) {

		userDAO.deleteRowFeb(theId);
	}

	@Override
	@Transactional
	public void saveExpendsFeb(FebruaryExpends theExpends) {

		userDAO.saveExpendsFeb(theExpends);
	}

	/*
	 * MARCH
	 */

	@Override
	@Transactional
	public List<MarchExpends> getMarchExpends() {

		return userDAO.getMarchExpends();
	}

	@Override
	@Transactional
	public Object[] getSumMar() {

		return userDAO.getSumMar();
	}

	@Override
	@Transactional
	public MarchExpends getExpMar(int theId) {

		return userDAO.getExpMar(theId);
	}

	@Override
	@Transactional
	public void deleteRowMar(int theId) {

		userDAO.deleteRowMar(theId);
	}

	@Override
	@Transactional
	public void saveExpendsMar(MarchExpends theExpends) {

		userDAO.saveExpendsMar(theExpends);
	}

	/*
	 * APRIL
	 */

	@Override
	@Transactional
	public List<AprilExpends> getAprilExpends() {

		return userDAO.getAprilExpends();
	}

	@Override
	@Transactional
	public Object[] getSumApr() {

		return userDAO.getSumApr();
	}

	@Override
	@Transactional
	public AprilExpends getExpApr(int theId) {

		return userDAO.getExpApr(theId);
	}

	@Override
	@Transactional
	public void deleteRowApr(int theId) {

		userDAO.deleteRowApr(theId);
	}

	@Override
	@Transactional
	public void saveExpendsApr(AprilExpends theExpends) {

		userDAO.saveExpendsApr(theExpends);
	}

	/*
	 * MAY
	 */

	@Override
	@Transactional
	public List<MayExpends> getMayExpends() {

		return userDAO.getMayExpends();
	}

	@Override
	@Transactional
	public Object[] getSumMay() {

		return userDAO.getSumMay();
	}

	@Override
	@Transactional
	public MayExpends getExpMay(int theId) {

		return userDAO.getExpMay(theId);
	}

	@Override
	@Transactional
	public void deleteRowMay(int theId) {

		userDAO.deleteRowMay(theId);
	}

	@Override
	@Transactional
	public void saveExpendsMay(MayExpends theExpends) {

		userDAO.saveExpendsMay(theExpends);
	}
	
	/*
	 * JUNE
	 */

	@Override
	@Transactional
	public List<JuneExpends> getJuneExpends() {

		return userDAO.getJuneExpends();
	}

	@Override
	@Transactional
	public Object[] getSumJun() {

		return userDAO.getSumJun();
	}

	@Override
	@Transactional
	public JuneExpends getExpJun(int theId) {

		return userDAO.getExpJun(theId);
	}

	@Override
	@Transactional
	public void deleteRowJun(int theId) {

		userDAO.deleteRowJun(theId);
	}

	@Override
	@Transactional
	public void saveExpendsJun(JuneExpends theExpends) {

		userDAO.saveExpendsJun(theExpends);
	}
	
	/*
	 * JULY
	 */

	@Override
	@Transactional
	public List<JulyExpends> getJulyExpends() {

		return userDAO.getJulyExpends();
	}

	@Override
	@Transactional
	public Object[] getSumJul() {

		return userDAO.getSumJul();
	}

	@Override
	@Transactional
	public JulyExpends getExpJul(int theId) {

		return userDAO.getExpJul(theId);
	}

	@Override
	@Transactional
	public void deleteRowJul(int theId) {

		userDAO.deleteRowJul(theId);
	}

	@Override
	@Transactional
	public void saveExpendsJul(JulyExpends theExpends) {

		userDAO.saveExpendsJul(theExpends);
	}
	
	/*
	 * AUGUST
	 */

	@Override
	@Transactional
	public List<AugustExpends> getAugustExpends() {

		return userDAO.getAugustExpends();
	}

	@Override
	@Transactional
	public Object[] getSumAug() {

		return userDAO.getSumAug();
	}

	@Override
	@Transactional
	public AugustExpends getExpAug(int theId) {

		return userDAO.getExpAug(theId);
	}

	@Override
	@Transactional
	public void deleteRowAug(int theId) {

		userDAO.deleteRowAug(theId);
	}

	@Override
	@Transactional
	public void saveExpendsAug(AugustExpends theExpends) {

		userDAO.saveExpendsAug(theExpends);
	}
	
	/*
	 * SEPTEMBER
	 */

	@Override
	@Transactional
	public List<SeptemberExpends> getSeptemberExpends() {

		return userDAO.getSeptemberExpends();
	}

	@Override
	@Transactional
	public Object[] getSumSep() {

		return userDAO.getSumSep();
	}

	@Override
	@Transactional
	public SeptemberExpends getExpSep(int theId) {

		return userDAO.getExpSep(theId);
	}

	@Override
	@Transactional
	public void deleteRowSep(int theId) {

		userDAO.deleteRowSep(theId);
	}

	@Override
	@Transactional
	public void saveExpendsSep(SeptemberExpends theExpends) {

		userDAO.saveExpendsSep(theExpends);
	}
	
	/*
	 * OCTOBER
	 */

	@Override
	@Transactional
	public List<OctoberExpends> getOctoberExpends() {

		return userDAO.getOctoberExpends();
	}

	@Override
	@Transactional
	public Object[] getSumOct() {

		return userDAO.getSumOct();
	}

	@Override
	@Transactional
	public OctoberExpends getExpOct(int theId) {

		return userDAO.getExpOct(theId);
	}

	@Override
	@Transactional
	public void deleteRowOct(int theId) {

		userDAO.deleteRowOct(theId);
	}

	@Override
	@Transactional
	public void saveExpendsOct(OctoberExpends theExpends) {

		userDAO.saveExpendsOct(theExpends);
	}
	
	/*
	 * NOVEMBER
	 */

	@Override
	@Transactional
	public List<NovemberExpends> getNovemberExpends() {

		return userDAO.getNovemberExpends();
	}

	@Override
	@Transactional
	public Object[] getSumNov() {

		return userDAO.getSumNov();
	}

	@Override
	@Transactional
	public NovemberExpends getExpNov(int theId) {

		return userDAO.getExpNov(theId);
	}

	@Override
	@Transactional
	public void deleteRowNov(int theId) {

		userDAO.deleteRowNov(theId);
	}

	@Override
	@Transactional
	public void saveExpendsNov(NovemberExpends theExpends) {

		userDAO.saveExpendsNov(theExpends);
	}
	
	/*
	 * DECEMBER
	 */

	@Override
	@Transactional
	public List<DecemberExpends> getDecemberExpends() {

		return userDAO.getDecemberExpends();
	}

	@Override
	@Transactional
	public Object[] getSumDec() {

		return userDAO.getSumDec();
	}

	@Override
	@Transactional
	public DecemberExpends getExpDec(int theId) {

		return userDAO.getExpDec(theId);
	}

	@Override
	@Transactional
	public void deleteRowDec(int theId) {

		userDAO.deleteRowDec(theId);
	}

	@Override
	@Transactional
	public void saveExpendsDec(DecemberExpends theExpends) {

		userDAO.saveExpendsDec(theExpends);
	}
}
