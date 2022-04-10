package com.aladhas.playstation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class expenses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	private String expdate;
	private String expname;
	private Double expprice;
	private String expemp;
	private String notes;

	public expenses() {

	}

	public expenses(Long iD, String expdate, String expname, Double expprice, String expemp, String notes) {
		ID = iD;
		this.expdate = expdate;
		this.expname = expname;
		this.expprice = expprice;
		this.expemp = expemp;
		this.notes = notes;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getExpdate() {
		return expdate;
	}

	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}

	public String getExpname() {
		return expname;
	}

	public void setExpname(String expname) {
		this.expname = expname;
	}

	public Double getExpprice() {
		return expprice;
	}

	public void setExpprice(Double expprice) {
		this.expprice = expprice;
	}

	public String getExpemp() {
		return expemp;
	}

	public void setExpemp(String expemp) {
		this.expemp = expemp;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
