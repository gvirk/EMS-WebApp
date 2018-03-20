package com.jarq.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "1_october_2018")
public class OctoberExpends {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "date")
	private String date;

	@Column(name = "eating")
	private double eating;

	@Column(name = "mobile")
	private double mobile;

	@Column(name = "flat")
	private double flat;

	@Column(name = "fuel")
	private double fuel;

	@Column(name = "tickets")
	private double tickets;

	@Column(name = "payment")
	private double payment;

	@Column(name = "other")
	private double other;

	@Transient
	private double total;

	public OctoberExpends() {
	}

	public OctoberExpends(int id, String date, double eating, double mobile, double flat, double fuel, double tickets,
			double payment, double other) {
		this.id = id;
		this.date = date;
		this.eating = eating;
		this.mobile = mobile;
		this.flat = flat;
		this.fuel = fuel;
		this.tickets = tickets;
		this.payment = payment;
		this.other = other;
		this.total = eating + mobile + flat + fuel + tickets + payment + other;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getEating() {
		return eating;
	}

	public void setEating(double eating) {
		this.eating = eating;
	}

	public double getMobile() {
		return mobile;
	}

	public void setMobile(double mobile) {
		this.mobile = mobile;
	}

	public double getFlat() {
		return flat;
	}

	public void setFlat(double flat) {
		this.flat = flat;
	}

	public double getFuel() {
		return fuel;
	}

	public void setFuel(double fuel) {
		this.fuel = fuel;
	}

	public double getTickets() {
		return tickets;
	}

	public void setTickets(double tickets) {
		this.tickets = tickets;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public double getOther() {
		return other;
	}

	public void setOther(double other) {
		this.other = other;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "JanuaryExpends [id=" + id + ", date=" + date + ", eating=" + eating + ", mobile=" + mobile + ", flat="
				+ flat + ", fuel=" + fuel + ", tickets=" + tickets + ", payment=" + payment + ", other=" + other
				+ ", total=" + total + "]";
	}

}
