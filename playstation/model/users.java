package com.aladhas.playstation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	private String Name;
	private String Username;
	private String Password;
	private Double Salary;
	private int shift;

	public users() {

	}

	public users(int id, String name, String username, String password, Double salary, int shift) {
		this.ID = id;
		this.Name = name;
		this.Username = username;
		this.Password = password;
		this.Salary = salary;
		this.shift = shift;
	}

	public int getId() {
		return ID;
	}

	public void setId(int id) {
		this.ID = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Double getSalary() {
		return Salary;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}

	public int getShift() {
		return shift;
	}

	public void setShift(int shift) {
		this.shift = shift;
	}

}
