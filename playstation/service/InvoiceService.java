package com.aladhas.playstation.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.aladhas.playstation.model.invoice;

public interface InvoiceService extends JpaRepository<invoice, Long>{

	@Modifying
	@Query("update invoice i set i.empinv=?1, i.totalinv=?2, i.notes=?3 where i.number=?4")
	void updateInvo(String emp, Double total,String notes,int number);
	
	@Query("select sum(totalinv) from invoice where dateof= ?1 and empinv= ?2")
	Double getTotalInvo(String dateof, String emp);
}
