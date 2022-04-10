package com.aladhas.playstation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aladhas.playstation.model.shifts;

@Service
@Transactional
public class ShiftsServiceImpl {

	@Autowired
	private ShiftsService serv;

	public List<shifts> listShifts() {
		return serv.findAll();

	}

	public void addShift(shifts shift) {
		serv.save(shift);
	}

	public shifts getShift(Long id) {
		return serv.findById(id).get();
	}

	public void updateShift(Long id, int number, String dateofshift, String shiftfrom, String shiftto, String emp,
			String notes) {
		serv.updateShift(id, number, dateofshift, shiftfrom, shiftto, emp, notes);
	}

	public void deleteShift(Long id) {
		serv.deleteById(id);
	}

	public String getShiftNum(String dateof, String emp) {
		return serv.getShiftNum(dateof, emp);
	}

}
