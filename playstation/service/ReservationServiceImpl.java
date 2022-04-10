package com.aladhas.playstation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aladhas.playstation.model.reservation;

@Service
@Transactional
public class ReservationServiceImpl {

	@Autowired
	private ReservationService serv;
	
	public void addReservation(reservation res) {
		serv.save(res);
	}
	
	public Long numberRes() {
		return serv.maxNum();
	}
}
