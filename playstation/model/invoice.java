package com.aladhas.playstation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	private int number;
	private String empinv;
	private String dateof;
	private Double totalinv;
	private String notes;

	public invoice() {

	}

	public invoice(Long iD, int number, String empinv, String dateof, Double totalinv, String notes) {
		super();
		ID = iD;
		this.number = number;
		this.empinv = empinv;
		this.dateof = dateof;
		this.totalinv = totalinv;
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

	public String getEmpinv() {
		return empinv;
	}

	public void setEmpinv(String empinv) {
		this.empinv = empinv;
	}

	public String getDateof() {
		return dateof;
	}

	public void setDateof(String dateof) {
		this.dateof = dateof;
	}

	public Double getTotalinv() {
		return totalinv;
	}

	public void setTotalinv(Double totalinv) {
		this.totalinv = totalinv;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
