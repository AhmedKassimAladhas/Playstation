package com.aladhas.playstation.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aladhas.playstation.model.shifts;

public interface ShiftsService extends JpaRepository<shifts, Long>{
	
	@Modifying
	@Query("update shifts s set s.number= :number, s.dateofshift= :dateofshift, s.shiftfrom= :shiftfrom, s.shiftto= :shiftto, s.emp= :emp, s.notes= :notes where ID= :id")
	void updateShift(@Param("id") Long id,@Param("number") int number,@Param("dateofshift") String dateofshift,@Param("shiftfrom") String shiftfrom,@Param("shiftto") String shiftto,@Param("emp") String emp,@Param("notes") String notes);
	
	@Query("select number from shifts where dateofshift=?1 and emp=?2")
	String getShiftNum(String dateof,String emp);
	
}
