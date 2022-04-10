package com.aladhas.playstation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class devices {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	private String typeps;
	private int number;
	private Double price_single;
	private Double price_multi;
	private String status;
	private String start;
	private int numberres;
	private int idline;
	private String drink;
	private String typereser;

	public devices() {

	}

	public devices(Long iD, String typeps, int number, Double price_single, Double price_multi, String status,
			String start, int numberres, int idline, String drink, String typereser) {
		this.ID = iD;
		this.typeps = typeps;
		this.number = number;
		this.price_single = price_single;
		this.price_multi = price_multi;
		this.status = status;
		this.start = start;
		this.numberres = numberres;
		this.idline = idline;
		this.drink = drink;
		this.typereser = typereser;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getTypeps() {
		return typeps;
	}

	public void setTypeps(String typeps) {
		this.typeps = typeps;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Double getPrice_single() {
		return price_single;
	}

	public void setPrice_single(Double price_single) {
		this.price_single = price_single;
	}

	public Double getPrice_multi() {
		return price_multi;
	}

	public void setPrice_multi(Double price_multi) {
		this.price_multi = price_multi;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public int getNumberres() {
		return numberres;
	}

	public void setNumberres(int numberres) {
		this.numberres = numberres;
	}

	public int getIdline() {
		return idline;
	}

	public void setIdline(int idline) {
		this.idline = idline;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getTypereser() {
		return typereser;
	}

	public void setTypereser(String typereser) {
		this.typereser = typereser;
	}

}
