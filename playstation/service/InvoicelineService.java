package com.aladhas.playstation.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.aladhas.playstation.model.invoiceline;

public interface InvoicelineService extends JpaRepository<invoiceline, Long>{

	@Modifying
	@Query("update invoiceline i set i.drinkt= ?1, i.drinkprice= ?2, i.drinkcount= ?3, i.drinktotal= ?4 where number= ?5 and devicenum= ?6")
	void editDrink(String DrinkT,Double DrinkPrice,int DrinkCount,Double Drinktotal,int id,int devicenum);
	
	@Modifying
	@Query("update invoiceline i set i.resto= ?1, i.resfrom= ?2, i.timecount= ?3, i.resprice= ?4, i.total= ?5 where ID= ?6 ")
	void endTime(String resto,String restfrom,String timecount,Double price,Double total, Long id);
	
	@Modifying
	@Query("update invoiceline i set i.typeofres= ?1, i.resfrom= ?2 where ID= ?3")
	void editType(String typeofres,String restfrom,Long id);
	
	@Query("select typeofres from invoiceline where number= ?1 and devicenum= ?2")
	String getTyp(int invo,int devicenum);
	
	@Query("select max(id) from invoiceline")
	int getMaxId();
	
	@Query("select drinktotal from invoiceline where ID= ?1")
	Double getDrinkTotal(Long id);
	
	@Query("select i from invoiceline i where i.number= ?1 and i.timecount != null ")
	List<invoiceline> findAllInvo(int number);
	
	@Query("select i from invoiceline i where i.number= ?1 and i.drinkt != null ")
	List<invoiceline> findAllInvoDrink(int number);
	
	@Query("select sum(total) from invoiceline where number= ?1")
	Double getTotalInvo(int number);
}
