package com.aladhas.playstation.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aladhas.playstation.model.dailyaccount;

public interface DailyAccountService extends JpaRepository<dailyaccount, Long>{

}
