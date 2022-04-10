package com.aladhas.playstation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aladhas.playstation.model.invoiceline;

@Service
@Transactional
public class InvoicelineServiceImpl {
	
	@Autowired
	private InvoicelineService serv;
	
	public void addLine(invoiceline line) {
		serv.save(line);
	}
	
	public void editDrink(String DrinkT,Double DrinkPrice,int DrinkCount,Double Drinktotal,int id,int devicenum) {
		serv.editDrink(DrinkT, DrinkPrice, DrinkCount,Drinktotal , id, devicenum);
	}
	
	public void endTime(String resto,String restfrom,String timecount,Double price,Double total,Long id) {
		serv.endTime(resto,restfrom, timecount,price,total, id);
	}
	
	public void editType(String typeofres,String restfrom,Long id) {
		serv.editType(typeofres,restfrom,id);
	}
	
	public int getMaxId() {
		return serv.getMaxId();
	}
	
	public String getTyp(int invo,int devicenum) {
		return serv.getTyp(invo, devicenum);
	}
	
	public Double getDrinkTotal(Long id) {
		return serv.getDrinkTotal(id);
	}
	
	public List<invoiceline> getAllInvo(int number){
		return serv.findAllInvo(number);
	}
	
	public List<invoiceline> getAllInvoDrink(int number){
		return serv.findAllInvoDrink(number);
	}
	
	public Double getTotalInvo(int number) {
		return serv.getTotalInvo(number);
	}
}
