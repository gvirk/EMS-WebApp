package com.jarq.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
import com.jarq.login.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	// need to inject user service
	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String listUsers(Model theModel) {

		// get users from dao
		List<User> theUsers = userService.getUsers();

		// add the users to the model
		theModel.addAttribute("users", theUsers);

		return "list-users";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		User theUser = new User();

		theModel.addAttribute("user", theUser);

		return "user-form";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User theUser) {

		// save the user using service
		userService.saveUser(theUser);

		return "redirect:/user/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel) {

		// get the user from service
		User theUser = userService.getUser(theId);

		// set user as a model attribute to pre-populate the form
		theModel.addAttribute("user", theUser);

		// send over to our form
		return "user-form";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int theId) {

		// delete the user
		userService.deleteUser(theId);

		return "redirect:/user/list";
	}

	@PostMapping("/search")
	public String searchUsers(@RequestParam("theSearchName") String theSearchName, Model theModel) {

		// search users from the service
		List<User> theUsers = userService.searchUsers(theSearchName);

		// add the users to the model
		theModel.addAttribute("users", theUsers);

		return "list-users";
	}
	
	@PostMapping("/saveExpendsJan")
	public String saveExpendsJan(@ModelAttribute("expendsJan") JanuaryExpends theExpends) {
	
		// save the user using service
		userService.saveExpendsJan(theExpends);

		return "redirect:/user/january";
	}

	@GetMapping("/deleteRowJan")
	public String deleteRowJan(@RequestParam("rowId") int theId) {

		// delete row
		userService.deleteRowJan(theId);

		return "redirect:/user/january";
	}

	@GetMapping("/showExpForUpdateJan")
	public String showExpForUpdateJan(@RequestParam("rowId") int theId, Model theModel) {

		// get the expends from service
		JanuaryExpends theExpJan = userService.getExpJan(theId);

		// set expends as a model attribute to pre-populate the form
		theModel.addAttribute("expendsJan", theExpJan);

		// send over to our form
		return "expends-form-jan";
	}
	
	@GetMapping("/showFormForAddExpendsJan")
	public String showFormForAddExpendsJan(Model theModel) {

		// create model attribute to bind form data
		JanuaryExpends theJanuaryExpends = new JanuaryExpends();

		theModel.addAttribute("expendsJan", theJanuaryExpends);

		return "expends-form-jan";
	}

	@GetMapping("/january")
	public String getJanuaryExpends(Model theModel) {

		// get expends from dao
		List<JanuaryExpends> theJanuaryExpends = userService.getJanuaryExpends();

		// get sum of columns from DAO
		Object[] theSumJan = userService.getSumJan();
		
		// get user and january incomings from DAO
		List<User> theUser = userService.getUser();

		// add the expends to the model
		theModel.addAttribute("januaryExpends", theJanuaryExpends);
		theModel.addAttribute("theSumJan", theSumJan);
		theModel.addAttribute("user", theUser);

		return "january-exp";
	}
	
	
   /*
	*	FEBRUARY
	*/
	
	@GetMapping("/february")
	public String getFebruaryExpends(Model theModel) {

		// get expends from dao
		List<FebruaryExpends> theFebruaryExpends = userService.getFebruaryExpends();

		// get sum of columns from DAO
		Object[] theSumFeb = userService.getSumFeb();
		
		// get user and february incomings from DAO
		List<User> theUser = userService.getUser();

		// add the expends to the model
		theModel.addAttribute("februaryExpends", theFebruaryExpends);
		theModel.addAttribute("theSumFeb", theSumFeb);
		theModel.addAttribute("user", theUser);

		return "february-exp";
	}
	
	@GetMapping("/deleteRowFeb")
	public String deleteRowFeb(@RequestParam("rowId") int theId) {

		// delete row
		userService.deleteRowFeb(theId);

		return "redirect:/user/february";
	}
	
	@PostMapping("/saveExpendsFeb")
	public String saveExpendsFeb(@ModelAttribute("expendsFeb") FebruaryExpends theExpends) {
	
		// save the user using service
		userService.saveExpendsFeb(theExpends);

		return "redirect:/user/february";
	}
	
	@GetMapping("/showExpForUpdateFeb")
	public String showExpForUpdateFeb(@RequestParam("rowId") int theId, Model theModel) {

		// get the expends from service
		FebruaryExpends theExpFeb = userService.getExpFeb(theId);

		// set expends as a model attribute to pre-populate the form
		theModel.addAttribute("expendsFeb", theExpFeb);

		// send over to our form
		return "expends-form-feb";
	}
	
	@GetMapping("/showFormForAddExpendsFeb")
	public String showFormForAddExpendsFeb(Model theModel) {

		// create model attribute to bind form data
		FebruaryExpends theFebruaryExpends = new FebruaryExpends();

		theModel.addAttribute("expendsFeb", theFebruaryExpends);

		return "expends-form-feb";
	}
	

   /*
	*	MARCH
	*/
	
	@GetMapping("/march")
	public String getMarchExpends(Model theModel) {

		// get expends from dao
		List<MarchExpends> theMarchExpends = userService.getMarchExpends();

		// get sum of columns from DAO
		Object[] theSumMar = userService.getSumMar();
		
		// get user and february incomings from DAO
		List<User> theUser = userService.getUser();

		// add the expends to the model
		theModel.addAttribute("marchExpends", theMarchExpends);
		theModel.addAttribute("theSumMar", theSumMar);
		theModel.addAttribute("user", theUser);

		return "march-exp";
	}
	
	@GetMapping("/deleteRowMar")
	public String deleteRowMar(@RequestParam("rowId") int theId) {

		// delete row
		userService.deleteRowMar(theId);

		return "redirect:/user/march";
	}
	
	@PostMapping("/saveExpendsMar")
	public String saveExpendsMar(@ModelAttribute("expendsMar") MarchExpends theExpends) {
	
		// save the user using service
		userService.saveExpendsMar(theExpends);

		return "redirect:/user/march";
	}
	
	@GetMapping("/showExpForUpdateMar")
	public String showExpForUpdateMar(@RequestParam("rowId") int theId, Model theModel) {

		// get the expends from service
		MarchExpends theExpMar = userService.getExpMar(theId);

		// set expends as a model attribute to pre-populate the form
		theModel.addAttribute("expendsMar", theExpMar);

		// send over to our form
		return "expends-form-mar";
	}
	
	@GetMapping("/showFormForAddExpendsMar")
	public String showFormForAddExpendsMar(Model theModel) {

		// create model attribute to bind form data
		MarchExpends theMarchExpends = new MarchExpends();

		theModel.addAttribute("expendsMar", theMarchExpends);

		return "expends-form-mar";
	}

   /*
	*	APRIL
	*/
	
	@GetMapping("/april")
	public String getAprilExpends(Model theModel) {

		// get expends from dao
		List<AprilExpends> theAprilExpends = userService.getAprilExpends();

		// get sum of columns from DAO
		Object[] theSumApr = userService.getSumApr();
		
		// get user and february incomings from DAO
		List<User> theUser = userService.getUser();

		// add the expends to the model
		theModel.addAttribute("aprilExpends", theAprilExpends);
		theModel.addAttribute("theSumApr", theSumApr);
		theModel.addAttribute("user", theUser);

		return "april-exp";
	}
	
	@GetMapping("/deleteRowApr")
	public String deleteRowApr(@RequestParam("rowId") int theId) {

		// delete row
		userService.deleteRowApr(theId);

		return "redirect:/user/april";
	}
	
	@PostMapping("/saveExpendsApr")
	public String saveExpendsApr(@ModelAttribute("expendsApr") AprilExpends theExpends) {
	
		// save the user using service
		userService.saveExpendsApr(theExpends);

		return "redirect:/user/april";
	}
	
	@GetMapping("/showExpForUpdateApr")
	public String showExpForUpdateApr(@RequestParam("rowId") int theId, Model theModel) {

		// get the expends from service
		AprilExpends theExpApr = userService.getExpApr(theId);

		// set expends as a model attribute to pre-populate the form
		theModel.addAttribute("expendsApr", theExpApr);

		// send over to our form
		return "expends-form-apr";
	}
	
	@GetMapping("/showFormForAddExpendsApr")
	public String showFormForAddExpendsApr(Model theModel) {

		// create model attribute to bind form data
		AprilExpends theAprilExpends = new AprilExpends();

		theModel.addAttribute("expendsApr", theAprilExpends);

		return "expends-form-apr";
	}

   /*
	*	MAY
	*/
	
	@GetMapping("/may")
	public String getMayExpends(Model theModel) {

		// get expends from dao
		List<MayExpends> theMayExpends = userService.getMayExpends();

		// get sum of columns from DAO
		Object[] theSumMay = userService.getSumMay();
		
		// get user and february incomings from DAO
		List<User> theUser = userService.getUser();

		// add the expends to the model
		theModel.addAttribute("mayExpends", theMayExpends);
		theModel.addAttribute("theSumMay", theSumMay);
		theModel.addAttribute("user", theUser);

		return "may-exp";
	}
	
	@GetMapping("/deleteRowMay")
	public String deleteRowMay(@RequestParam("rowId") int theId) {

		// delete row
		userService.deleteRowApr(theId);

		return "redirect:/user/may";
	}
	
	@PostMapping("/saveExpendsMay")
	public String saveExpendsMay(@ModelAttribute("expendsMay") MayExpends theExpends) {
	
		// save the user using service
		userService.saveExpendsMay(theExpends);

		return "redirect:/user/may";
	}
	
	@GetMapping("/showExpForUpdateMay")
	public String showExpForUpdateMay(@RequestParam("rowId") int theId, Model theModel) {

		// get the expends from service
		MayExpends theExpMay = userService.getExpMay(theId);

		// set expends as a model attribute to pre-populate the form
		theModel.addAttribute("expendsMay", theExpMay);

		// send over to our form
		return "expends-form-may";
	}
	
	@GetMapping("/showFormForAddExpendsMay")
	public String showFormForAddExpendsMay(Model theModel) {

		// create model attribute to bind form data
		MayExpends theMayExpends = new MayExpends();

		theModel.addAttribute("expendsMay", theMayExpends);

		return "expends-form-may";
	}

   /*
	*	JUNE
	*/
	
	@GetMapping("/june")
	public String getJuneExpends(Model theModel) {

		// get expends from dao
		List<JuneExpends> theJuneExpends = userService.getJuneExpends();

		// get sum of columns from DAO
		Object[] theSumJun = userService.getSumJun();
		
		// get user and february incomings from DAO
		List<User> theUser = userService.getUser();

		// add the expends to the model
		theModel.addAttribute("juneExpends", theJuneExpends);
		theModel.addAttribute("theSumJun", theSumJun);
		theModel.addAttribute("user", theUser);

		return "june-exp";
	}
	
	@GetMapping("/deleteRowJun")
	public String deleteRowJun(@RequestParam("rowId") int theId) {

		// delete row
		userService.deleteRowJun(theId);

		return "redirect:/user/june";
	}
	
	@PostMapping("/saveExpendsJun")
	public String saveExpendsJun(@ModelAttribute("expendsJun") JuneExpends theExpends) {
	
		// save the user using service
		userService.saveExpendsJun(theExpends);

		return "redirect:/user/june";
	}
	
	@GetMapping("/showExpForUpdateJun")
	public String showExpForUpdateJun(@RequestParam("rowId") int theId, Model theModel) {

		// get the expends from service
		JuneExpends theExpJun = userService.getExpJun(theId);

		// set expends as a model attribute to pre-populate the form
		theModel.addAttribute("expendsJun", theExpJun);

		// send over to our form
		return "expends-form-jun";
	}
	
	@GetMapping("/showFormForAddExpendsJun")
	public String showFormForAddExpendsJun(Model theModel) {

		// create model attribute to bind form data
		JuneExpends theJuneExpends = new JuneExpends();

		theModel.addAttribute("expendsJun", theJuneExpends);

		return "expends-form-jun";
	}	

   /*
	*	JULY
	*/
	
	@GetMapping("/july")
	public String getJulyExpends(Model theModel) {

		// get expends from dao
		List<JulyExpends> theJulyExpends = userService.getJulyExpends();

		// get sum of columns from DAO
		Object[] theSumJul = userService.getSumJul();
		
		// get user and february incomings from DAO
		List<User> theUser = userService.getUser();

		// add the expends to the model
		theModel.addAttribute("julyExpends", theJulyExpends);
		theModel.addAttribute("theSumJul", theSumJul);
		theModel.addAttribute("user", theUser);

		return "july-exp";
	}
	
	@GetMapping("/deleteRowJul")
	public String deleteRowJul(@RequestParam("rowId") int theId) {

		// delete row
		userService.deleteRowJul(theId);

		return "redirect:/user/july";
	}
	
	@PostMapping("/saveExpendsJul")
	public String saveExpendsJul(@ModelAttribute("expendsJul") JulyExpends theExpends) {
	
		// save the user using service
		userService.saveExpendsJul(theExpends);

		return "redirect:/user/july";
	}
	
	@GetMapping("/showExpForUpdateJul")
	public String showExpForUpdateJul(@RequestParam("rowId") int theId, Model theModel) {

		// get the expends from service
		JulyExpends theExpJul = userService.getExpJul(theId);

		// set expends as a model attribute to pre-populate the form
		theModel.addAttribute("expendsJul", theExpJul);

		// send over to our form
		return "expends-form-jul";
	}
	
	@GetMapping("/showFormForAddExpendsJul")
	public String showFormForAddExpendsJul(Model theModel) {

		// create model attribute to bind form data
		JulyExpends theJulyExpends = new JulyExpends();

		theModel.addAttribute("expendsJul", theJulyExpends);

		return "expends-form-jul";
	}	
	
   /*
	*	AUGUST
	*/
	
	@GetMapping("/august")
	public String getAugustExpends(Model theModel) {

		// get expends from dao
		List<AugustExpends> theAugustExpends = userService.getAugustExpends();

		// get sum of columns from DAO
		Object[] theSumAug = userService.getSumAug();
		
		// get user and february incomings from DAO
		List<User> theUser = userService.getUser();

		// add the expends to the model
		theModel.addAttribute("augustExpends", theAugustExpends);
		theModel.addAttribute("theSumAug", theSumAug);
		theModel.addAttribute("user", theUser);

		return "august-exp";
	}
	
	@GetMapping("/deleteRowAug")
	public String deleteRowAug(@RequestParam("rowId") int theId) {

		// delete row
		userService.deleteRowAug(theId);

		return "redirect:/user/august";
	}
	
	@PostMapping("/saveExpendsAug")
	public String saveExpendsAug(@ModelAttribute("expendsAug") AugustExpends theExpends) {
	
		// save the user using service
		userService.saveExpendsAug(theExpends);

		return "redirect:/user/august";
	}
	
	@GetMapping("/showExpForUpdateAug")
	public String showExpForUpdateAug(@RequestParam("rowId") int theId, Model theModel) {

		// get the expends from service
		AugustExpends theExpAug = userService.getExpAug(theId);

		// set expends as a model attribute to pre-populate the form
		theModel.addAttribute("expendsAug", theExpAug);

		// send over to our form
		return "expends-form-aug";
	}
	
	@GetMapping("/showFormForAddExpendsAug")
	public String showFormForAddExpendsAug(Model theModel) {

		// create model attribute to bind form data
		AugustExpends theAugustExpends = new AugustExpends();

		theModel.addAttribute("expendsAug", theAugustExpends);

		return "expends-form-aug";
	}
	
   /*
	*	SEPTEMBER
	*/
	
	@GetMapping("/september")
	public String getSeptemberExpends(Model theModel) {

		// get expends from dao
		List<SeptemberExpends> theSeptemberExpends = userService.getSeptemberExpends();

		// get sum of columns from DAO
		Object[] theSumSep = userService.getSumSep();
		
		// get user and february incomings from DAO
		List<User> theUser = userService.getUser();

		// add the expends to the model
		theModel.addAttribute("septemberExpends", theSeptemberExpends);
		theModel.addAttribute("theSumSep", theSumSep);
		theModel.addAttribute("user", theUser);

		return "september-exp";
	}
	
	@GetMapping("/deleteRowSep")
	public String deleteRowSep(@RequestParam("rowId") int theId) {

		// delete row
		userService.deleteRowSep(theId);

		return "redirect:/user/september";
	}
	
	@PostMapping("/saveExpendsSep")
	public String saveExpendsSep(@ModelAttribute("expendsSep") SeptemberExpends theExpends) {
	
		// save the user using service
		userService.saveExpendsSep(theExpends);

		return "redirect:/user/september";
	}
	
	@GetMapping("/showExpForUpdateSep")
	public String showExpForUpdateSep(@RequestParam("rowId") int theId, Model theModel) {

		// get the expends from service
		SeptemberExpends theExpSep = userService.getExpSep(theId);

		// set expends as a model attribute to pre-populate the form
		theModel.addAttribute("expendsSep", theExpSep);

		// send over to our form
		return "expends-form-sep";
	}
	
	@GetMapping("/showFormForAddExpendsSep")
	public String showFormForAddExpendsSep(Model theModel) {

		// create model attribute to bind form data
		SeptemberExpends theSeptemberExpends = new SeptemberExpends();

		theModel.addAttribute("expendsSep", theSeptemberExpends);

		return "expends-form-sep";
	}

   /*
	*	OCTOBER
	*/
	
	@GetMapping("/october")
	public String getOctoberExpends(Model theModel) {

		// get expends from dao
		List<OctoberExpends> theOctoberExpends = userService.getOctoberExpends();

		// get sum of columns from DAO
		Object[] theSumOct = userService.getSumOct();
		
		// get user and february incomings from DAO
		List<User> theUser = userService.getUser();

		// add the expends to the model
		theModel.addAttribute("octoberExpends", theOctoberExpends);
		theModel.addAttribute("theSumOct", theSumOct);
		theModel.addAttribute("user", theUser);

		return "october-exp";
	}
	
	@GetMapping("/deleteRowOct")
	public String deleteRowOct(@RequestParam("rowId") int theId) {

		// delete row
		userService.deleteRowOct(theId);

		return "redirect:/user/october";
	}
	
	@PostMapping("/saveExpendsOct")
	public String saveExpendsOct(@ModelAttribute("expendsOct") OctoberExpends theExpends) {
	
		// save the user using service
		userService.saveExpendsOct(theExpends);

		return "redirect:/user/october";
	}
	
	@GetMapping("/showExpForUpdateOct")
	public String showExpForUpdateOct(@RequestParam("rowId") int theId, Model theModel) {

		// get the expends from service
		OctoberExpends theExpOct = userService.getExpOct(theId);

		// set expends as a model attribute to pre-populate the form
		theModel.addAttribute("expendsOct", theExpOct);

		// send over to our form
		return "expends-form-oct";
	}
	
	@GetMapping("/showFormForAddExpendsOct")
	public String showFormForAddExpendsOct(Model theModel) {

		// create model attribute to bind form data
		OctoberExpends theOctoberExpends = new OctoberExpends();

		theModel.addAttribute("expendsOct", theOctoberExpends);

		return "expends-form-oct";
	}
	
   /*
	*	NOVEMBER
	*/
	
	@GetMapping("/november")
	public String getNovemberExpends(Model theModel) {

		// get expends from dao
		List<NovemberExpends> theNovemberExpends = userService.getNovemberExpends();

		// get sum of columns from DAO
		Object[] theSumNov = userService.getSumNov();
		
		// get user and february incomings from DAO
		List<User> theUser = userService.getUser();

		// add the expends to the model
		theModel.addAttribute("novemberExpends", theNovemberExpends);
		theModel.addAttribute("theSumNov", theSumNov);
		theModel.addAttribute("user", theUser);

		return "november-exp";
	}
	
	@GetMapping("/deleteRowNov")
	public String deleteRowNov(@RequestParam("rowId") int theId) {

		// delete row
		userService.deleteRowNov(theId);

		return "redirect:/user/november";
	}
	
	@PostMapping("/saveExpendsNov")
	public String saveExpendsNov(@ModelAttribute("expendsNov") NovemberExpends theExpends) {
	
		// save the user using service
		userService.saveExpendsNov(theExpends);

		return "redirect:/user/november";
	}
	
	@GetMapping("/showExpForUpdateNov")
	public String showExpForUpdateNov(@RequestParam("rowId") int theId, Model theModel) {

		// get the expends from service
		NovemberExpends theExpNov = userService.getExpNov(theId);

		// set expends as a model attribute to pre-populate the form
		theModel.addAttribute("expendsNov", theExpNov);

		// send over to our form
		return "expends-form-nov";
	}
	
	@GetMapping("/showFormForAddExpendsNov")
	public String showFormForAddExpendsNov(Model theModel) {

		// create model attribute to bind form data
		NovemberExpends theNovemberExpends = new NovemberExpends();

		theModel.addAttribute("expendsNov", theNovemberExpends);

		return "expends-form-nov";
	}
	
   /*
	*	DECEMBER
	*/
	
	@GetMapping("/december")
	public String getDecemberExpends(Model theModel) {

		// get expends from dao
		List<DecemberExpends> theDecemberExpends = userService.getDecemberExpends();

		// get sum of columns from DAO
		Object[] theSumDec = userService.getSumDec();
		
		// get user and february incomings from DAO
		List<User> theUser = userService.getUser();

		// add the expends to the model
		theModel.addAttribute("decemberExpends", theDecemberExpends);
		theModel.addAttribute("theSumDec", theSumDec);
		theModel.addAttribute("user", theUser);

		return "december-exp";
	}
	
	@GetMapping("/deleteRowDec")
	public String deleteRowDec(@RequestParam("rowId") int theId) {

		// delete row
		userService.deleteRowDec(theId);

		return "redirect:/user/december";
	}
	
	@PostMapping("/saveExpendsDec")
	public String saveExpendsDec(@ModelAttribute("expendsDec") DecemberExpends theExpends) {
	
		// save the user using service
		userService.saveExpendsDec(theExpends);

		return "redirect:/user/december";
	}
	
	@GetMapping("/showExpForUpdateDec")
	public String showExpForUpdateDec(@RequestParam("rowId") int theId, Model theModel) {

		// get the expends from service
		DecemberExpends theExpDec = userService.getExpDec(theId);

		// set expends as a model attribute to pre-populate the form
		theModel.addAttribute("expendsDec", theExpDec);

		// send over to our form
		return "expends-form-dec";
	}
	
	@GetMapping("/showFormForAddExpendsDec")
	public String showFormForAddExpendsDec(Model theModel) {

		// create model attribute to bind form data
		DecemberExpends theDecemberExpends = new DecemberExpends();

		theModel.addAttribute("expendsDec", theDecemberExpends);

		return "expends-form-dec";
	}
}
