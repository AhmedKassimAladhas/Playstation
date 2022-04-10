package com.aladhas.playstation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class shifts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	private int number;
	private String dateofshift;
	private String shiftfrom;
	private String shiftto;
	private String emp;
	private String notes;

	public shifts() {

	}

	public shifts(Long iD, int number, String dateofshift, String shiftfrom, String shiftto, String emp, String notes) {
		this.ID = iD;
		this.number = number;
		this.dateofshift = dateofshift;
		this.shiftfrom = shiftfrom;
		this.shiftto = shiftto;
		this.emp = emp;
		this.notes = notes;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDateofshift() {
		return dateofshift;
	}

	public void setDateofshift(String dateofshift) {
		this.dateofshift = dateofshift;
	}

	public String getShiftfrom() {
		return shiftfrom;
	}

	public void setShiftfrom(String shiftfrom) {
		this.shiftfrom = shiftfrom;
	}

	public String getShiftto() {
		return shiftto;
	}

	public void setShiftto(String shiftto) {
		this.shiftto = shiftto;
	}

	public String getEmp() {
		return emp;
	}

	public void setEmp(String emp) {
		this.emp = emp;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
