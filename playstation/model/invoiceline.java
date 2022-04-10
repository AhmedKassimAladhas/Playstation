package com.aladhas.playstation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class invoiceline {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	private int number;
	private String timecount;
	private Double resprice;
	private int devicenum;
	private String typeofres;
	private String resfrom;
	private String resto;
	private String drinkt;
	private Double drinkprice;
	private int drinkcount;
	private Double drinktotal;
	private Double total;
	private String notes;

	public invoiceline() {

	}

	public invoiceline(Long iD, int number, String timecount, Double resprice, int devicenum, String typeofres,
			String resfrom, String resto, String drinkt, Double drinkprice, int drinkcount, Double drinktotal,
			Double total, String notes) {
		ID = iD;
		this.number = number;
		this.timecount = timecount;
		this.devicenum = devicenum;
		this.typeofres = typeofres;
		this.resfrom = resfrom;
		this.resto = resto;
		this.resprice = resprice;
		this.drinkt = drinkt;
		this.drinkprice = drinkprice;
		this.drinkcount = drinkcount;
		this.drinktotal = drinktotal;
		this.total = total;
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

	public String getTimecount() {
		return timecount;
	}

	public void setTimecount(String timecount) {
		this.timecount = timecount;
	}

	public Double getResprice() {
		return resprice;
	}

	public void setResprice(Double resprice) {
		this.resprice = resprice;
	}

	public String getDrinkt() {
		return drinkt;
	}

	public void setDrinkt(String drinkt) {
		this.drinkt = drinkt;
	}

	public Double getDrinkprice() {
		return drinkprice;
	}

	public void setDrinkprice(Double drinkprice) {
		this.drinkprice = drinkprice;
	}

	public int getDrinkcount() {
		return drinkcount;
	}

	public void setDrinkcount(int drinkcount) {
		this.drinkcount = drinkcount;
	}

	public Double getDrinktotal() {
		return drinktotal;
	}

	public void setDrinktotal(Double drinktotal) {
		this.drinktotal = drinktotal;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
