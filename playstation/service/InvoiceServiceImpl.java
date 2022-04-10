package com.aladhas.playstation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aladhas.playstation.model.invoice;

@Service
@Transactional
public class InvoiceServiceImpl {

	@Autowired
	private InvoiceService serv;

	public void addInv(invoice inv) {
		serv.save(inv);
	}

	public void updateInvo(String emp, Double total, String notes, int number) {
		serv.updateInvo(emp, total, notes, number);
	}

	public Double gettotalInvo(String dateof, String emp) {
		return serv.getTotalInvo(dateof, emp);
	}
}
