package com.jarq.login.service;

import java.util.List;

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

public interface UserService {

	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(int theId);

	public void deleteUser(int theId);

	public List<User> searchUsers(String theSearchName);

	public List<JanuaryExpends> getJanuaryExpends();

	public Object[] getSumJan();

	public void deleteRowJan(int theId);

	public JanuaryExpends getExpJan(int theId);

	public void saveExpendsJan(JanuaryExpends theExpends);

	public void saveNewExpendsJan(JanuaryExpends theJanuaryExpends);

	public List<User> getUser();

	/*
	 * February
	 */

	public List<FebruaryExpends> getFebruaryExpends();

	public Object[] getSumFeb();

	public FebruaryExpends getExpFeb(int theId);

	public void deleteRowFeb(int theId);

	public void saveExpendsFeb(FebruaryExpends theExpends);

	/*
	 * March
	 */

	public List<MarchExpends> getMarchExpends();

	public Object[] getSumMar();

	public MarchExpends getExpMar(int theId);

	public void deleteRowMar(int theId);

	public void saveExpendsMar(MarchExpends theExpends);

	/*
	 * April
	 */

	public List<AprilExpends> getAprilExpends();

	public Object[] getSumApr();

	public AprilExpends getExpApr(int theId);

	public void deleteRowApr(int theId);

	public void saveExpendsApr(AprilExpends theExpends);

	/*
	 * May
	 */

	public List<MayExpends> getMayExpends();

	public Object[] getSumMay();

	public MayExpends getExpMay(int theId);

	public void deleteRowMay(int theId);

	public void saveExpendsMay(MayExpends theExpends);
	
	/*
	 * June
	 */

	public List<JuneExpends> getJuneExpends();

	public Object[] getSumJun();

	public JuneExpends getExpJun(int theId);

	public void deleteRowJun(int theId);

	public void saveExpendsJun(JuneExpends theExpends);

	/*
	 * July
	 */

	public List<JulyExpends> getJulyExpends();

	public Object[] getSumJul();

	public JulyExpends getExpJul(int theId);

	public void deleteRowJul(int theId);

	public void saveExpendsJul(JulyExpends theExpends);
	
	/*
	 * August
	 */

	public List<AugustExpends> getAugustExpends();

	public Object[] getSumAug();

	public AugustExpends getExpAug(int theId);

	public void deleteRowAug(int theId);

	public void saveExpendsAug(AugustExpends theExpends);

	/*
	 * September
	 */

	public List<SeptemberExpends> getSeptemberExpends();

	public Object[] getSumSep();

	public SeptemberExpends getExpSep(int theId);

	public void deleteRowSep(int theId);

	public void saveExpendsSep(SeptemberExpends theExpends);
	
	/*
	 * October
	 */

	public List<OctoberExpends> getOctoberExpends();

	public Object[] getSumOct();

	public OctoberExpends getExpOct(int theId);

	public void deleteRowOct(int theId);

	public void saveExpendsOct(OctoberExpends theExpends);
	
	/*
	 * November
	 */

	public List<NovemberExpends> getNovemberExpends();

	public Object[] getSumNov();

	public NovemberExpends getExpNov(int theId);

	public void deleteRowNov(int theId);

	public void saveExpendsNov(NovemberExpends theExpends);
	
	/*
	 * December
	 */

	public List<DecemberExpends> getDecemberExpends();

	public Object[] getSumDec();

	public DecemberExpends getExpDec(int theId);

	public void deleteRowDec(int theId);

	public void saveExpendsDec(DecemberExpends theExpends);
}
