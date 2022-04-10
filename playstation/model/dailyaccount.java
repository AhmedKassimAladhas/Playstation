package com.aladhas.playstation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class dailyaccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	private String dateofacc;
	private int shiftnum;
	private String empname;
	private Double exp;
	private Double invtotal;
	private Double total;
	private String notes;

	public dailyaccount() {

	}

	public dailyaccount(Long iD, String dateofacc, int shiftnum, String empname, Double exp, Double invtotal,
			Double total, String notes) {
		ID = iD;
		this.dateofacc = dateofacc;
		this.shiftnum = shiftnum;
		this.empname = empname;
		this.exp = exp;
		this.invtotal = invtotal;
		this.total = total;
		this.notes = notes;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getDateofacc() {
		return dateofacc;
	}

	public void setDateofacc(String dateofacc) {
		this.dateofacc = dateofacc;
	}

	public int getShiftnum() {
		return shiftnum;
	}

	public void setShiftnum(int shiftnum) {
		this.shiftnum = shiftnum;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Double getExp() {
		return exp;
	}

	public void setExp(Double exp) {
		this.exp = exp;
	}

	public Double getInvtotal() {
		return invtotal;
	}

	public void setInvtotal(Double invtotal) {
		this.invtotal = invtotal;
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
