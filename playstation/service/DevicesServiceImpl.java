package com.aladhas.playstation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aladhas.playstation.model.devices;

@Service
@Transactional
public class DevicesServiceImpl {

	@Autowired
	private DevicesService serv;

	public List<devices> listDevice() {
		return serv.findAll();
	}

	public List<devices> listDeviceByStatus(String status) {
		return serv.findByStatus(status);
	}
	
	public void addDV(devices play) {
		serv.save(play);
	}

	public devices getDV(Long id) {
		return serv.findById(id).get();
	}

	public devices getDVid(Long id) {
		return serv.getOne(id);
	}

	public void deleteDV(Long id) {
		serv.deleteById(id);
	}

	public void updateDV(Long id, String type, int number, Double price_single, Double price_multi) {
		serv.edit(id, type, number, price_single, price_multi);
	}

	public void updateDVR(String status, String start, int numberres, int idline, String typereser, int id) {
		serv.editRes(status, start, numberres, idline, typereser, id);
	}

	public void drinkR(String drink, int number) {
		serv.drinkRes(drink, number);
	}

	public void drinkDelet(String drink, int number) {
		serv.drinkResDelet(drink, number);
	}

	public void updateResType(String start, String typereser, int idline, int id) {
		serv.updateRes(start, typereser, idline, id);
	}

	public Long getMaxNum(Long number) {
		return serv.maxNum(number);
	}

	public int getDevNum(int number) {
		return serv.devNum(number);
	}

	public String getMaxDrink(Long number) {
		return serv.maxDrink(number);
	}

	public String getMaxStart(int number) {
		return serv.maxStart(number);
	}

	public Double getPriceSingle(int number) {
		return serv.priceSingle(number);
	}

	public Double getPriceMulti(int number) {
		return serv.priceMulti(number);
	}

	public String getTypeRes(int number) {
		return serv.typeRes(number);
	}

	public Long getDevIdline(int number) {
		return serv.devIdline(number);
	}

	public int countDevRes() {
		return serv.countDevRes();
	}

	public int countEmpty() {
		return serv.countEmpty();
	}

	public int countDev() {
		return serv.countDev();
	}
	
	public int getNumDevic() {
		return serv.getNumDevic();
	}
}
