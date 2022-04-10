package com.aladhas.playstation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	private int number;
	private int devicenum;
	private String typeofres;
	private String dateof;
	private String resfrom;
	private String resto;
	private String restotal;
	private String notes;

	public reservation() {
		
	}
	
	public reservation(Long iD, int number, int devicenum, String typeofres, String dateof, String resfrom,
			String resto, String restotal, String notes) {
		this.ID = iD;
		this.number = number;
		this.devicenum = devicenum;
		this.typeofres = typeofres;
		this.dateof = dateof;
		this.resfrom = resfrom;
		this.resto = resto;
		this.restotal = restotal;
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

	public int getDevicenum() {
		return devicenum;
	}

	public void setDevicenum(int devicenum) {
		this.devicenum = devicenum;
	}

	public String getTypeofres() {
		return typeofres;
	}

	public void setTypeofres(String typeofres) {
		this.typeofres = typeofres;
	}

	public String getDateof() {
		return dateof;
	}

	public void setDateof(String dateof) {
		this.dateof = dateof;
	}

	public String getResfrom() {
		return resfrom;
	}

	public void setResfrom(String resfrom) {
		this.resfrom = resfrom;
	}

	public String getResto() {
		return resto;
	}

	public void setResto(String resto) {
		this.resto = resto;
	}

	public String getRestotal() {
		return restotal;
	}

	public void setRestotal(String restotal) {
		this.restotal = restotal;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
