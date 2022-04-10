package com.aladhas.playstation.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aladhas.playstation.model.drinks;

public interface DrinkService extends JpaRepository<drinks, Long> {

	@Modifying
	@Query("update drinks d set d.drinkType= :drinkType, d.price= :price, d.notes= :notes where ID= :id")
	void edit(@Param("id") Long id,@Param("drinkType") String drinkType,@Param("price") Double price,@Param("notes") String notes);
	
	@Query("select price from drinks where drinkType= ?1")
	Double getPrice(String drinkType);
	
	@Query("select drinkType from drinks ")
	List<drinks> getType();
	
}
