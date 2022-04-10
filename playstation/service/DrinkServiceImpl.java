package com.aladhas.playstation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aladhas.playstation.model.drinks;

@Service
@Transactional
public class DrinkServiceImpl {

	@Autowired
	private DrinkService serv;

	public List<drinks> listDrink() {
		return serv.findAll();
	}
	
	public void addDrink(drinks drink) {
		serv.save(drink);
	}
	
	public drinks getDrink(Long id) {
		return serv.findById(id).get();
	}
	
	public List<drinks> getTyp() {
		return serv.getType();
	}
	
	public void updateDrink(Long id,String drinkType,Double price, String notes) {
		serv.edit(id, drinkType, price, notes);
	}
	
	public void deleteDrink(Long id) {
		serv.deleteById(id);
	}
	
	public Double getPriceD(String drinkType) {
		return serv.getPrice(drinkType);
	}
}
