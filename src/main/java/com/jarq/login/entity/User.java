package com.jarq.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dane")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "age")
	private int age;

	@Column(name = "january_salary")
	private String januarySalary;

	@Column(name = "february_salary")
	private String februarySalary;

	@Column(name = "march_salary")
	private String marchSalary;

	@Column(name = "april_salary")
	private String aprilSalary;

	@Column(name = "may_salary")
	private String maySalary;

	@Column(name = "june_salary")
	private String juneSalary;

	@Column(name = "july_salary")
	private String julySalary;

	@Column(name = "august_salary")
	private String augustSalary;

	@Column(name = "september_salary")
	private String septemberSalary;

	@Column(name = "october_salary")
	private String octoberSalary;

	@Column(name = "november_salary")
	private String novemberSalary;

	@Column(name = "december_salary")
	private String decemberSalary;

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJanuarySalary() {
		return januarySalary;
	}

	public void setJanuarySalary(String januarySalary) {
		this.januarySalary = januarySalary;
	}

	public String getFebruarySalary() {
		return februarySalary;
	}

	public void setFebruarySalary(String februarySalary) {
		this.februarySalary = februarySalary;
	}

	public String getMarchSalary() {
		return marchSalary;
	}

	public void setMarchSalary(String marchSalary) {
		this.marchSalary = marchSalary;
	}

	public String getAprilSalary() {
		return aprilSalary;
	}

	public void setAprilSalary(String aprilSalary) {
		this.aprilSalary = aprilSalary;
	}

	public String getMaySalary() {
		return maySalary;
	}

	public void setMaySalary(String maySalary) {
		this.maySalary = maySalary;
	}

	public String getJuneSalary() {
		return juneSalary;
	}

	public void setJuneSalary(String juneSalary) {
		this.juneSalary = juneSalary;
	}

	public String getJulySalary() {
		return julySalary;
	}

	public void setJulySalary(String julySalary) {
		this.julySalary = julySalary;
	}

	public String getAugustSalary() {
		return augustSalary;
	}

	public void setAugustSalary(String augustSalary) {
		this.augustSalary = augustSalary;
	}

	public String getSeptemberSalary() {
		return septemberSalary;
	}

	public void setSeptemberSalary(String septemberSalary) {
		this.septemberSalary = septemberSalary;
	}

	public String getOctoberSalary() {
		return octoberSalary;
	}

	public void setOctoberSalary(String octoberSalary) {
		this.octoberSalary = octoberSalary;
	}

	public String getNovemberSalary() {
		return novemberSalary;
	}

	public void setNovemberSalary(String novemberSalary) {
		this.novemberSalary = novemberSalary;
	}

	public String getDecemberSalary() {
		return decemberSalary;
	}

	public void setDecemberSalary(String decemberSalary) {
		this.decemberSalary = decemberSalary;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", age=" + age + "]";
	}

}
