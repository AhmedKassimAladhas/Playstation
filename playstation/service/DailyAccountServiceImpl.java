package com.aladhas.playstation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aladhas.playstation.model.dailyaccount;


@Service
@Transactional
public class DailyAccountServiceImpl {

	@Autowired
	private DailyAccountService serv;
	
	public List<dailyaccount> listAll(){
		return serv.findAll();
	}
	
	public void saveDaily(dailyaccount daily) {
		serv.save(daily);
	}
	
	public void deleteDaily(Long id) {
		serv.deleteById(id);
	}
}
