package com.aladhas.playstation.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aladhas.playstation.model.expenses;

public interface ExpensesService extends JpaRepository<expenses, Long> {

	@Query("select sum(expprice) from expenses where expdate= ?1 and expemp= ?2")
	Double getExp(String dateof, String emp);
}
