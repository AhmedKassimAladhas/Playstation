package com.aladhas.playstation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aladhas.playstation.model.expenses;

@Service
@Transactional
public class ExpensesServiceImpl {

	@Autowired
	private ExpensesService serv;

	public void addExpens(expenses expens) {
		serv.save(expens);
	}

	public void deleteExpens(Long id) {
		serv.deleteById(id);
	}

	public List<expenses> getExpens() {
		return serv.findAll();
	}

	public Double getExp(String dateof, String emp) {
		return serv.getExp(dateof, emp);
	}
}
