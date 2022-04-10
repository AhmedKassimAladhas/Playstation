package com.aladhas.playstation.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aladhas.playstation.model.reservation;

public interface ReservationService extends JpaRepository<reservation, Long> {

	
	@Query("SELECT MAX(number+1) FROM reservation")
	Long maxNum();
}
