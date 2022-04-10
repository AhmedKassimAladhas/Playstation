package com.aladhas.playstation.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aladhas.playstation.model.devices;

public interface DevicesService extends JpaRepository<devices, Long> {

	@Modifying
	@Query("update devices v set v.typeps= :typeps, v.number= :number, v.price_single= :price_single, v.price_multi= :price_multi where ID= :id")
	void edit(@Param("id") Long id,@Param("typeps") String type,@Param("number") int number,@Param("price_single") Double price_single,@Param("price_multi") Double price_multi);
	
	@Modifying
	@Query("update devices v set  v.status= ?1, v.start= ?2, v.numberres= ?3, v.idline= ?4, v.typereser= ?5 where Number= ?6")
	void editRes(String status,String start,int numberres,int idline,String typereser,int id);
	
	@Modifying
	@Query("update devices v set  v.drink= ?1 where numberres= ?2")
	void drinkRes(String drink,int number);
	
	@Modifying
	@Query("update devices v set  v.drink= ?1 where number= ?2")
	void drinkResDelet(String drink,int number);
	
	@Modifying
	@Query("update devices v set   v.start= ?1,  v.typereser= ?2, v.idline= ?3 where Number= ?4")
	void updateRes(String start,String typereser,int idline,int id);
	
	@Query("SELECT numberres FROM devices where Number= ?1")
	Long maxNum(Long number);
	
	@Query("SELECT number FROM devices where numberres= ?1")
	int devNum(int number);
	
	@Query("SELECT drink FROM devices where Number= ?1")
	String maxDrink(Long number);
	
	@Query("SELECT start FROM devices where Number= ?1")
	String maxStart(int number);
	
	@Query("SELECT price_single FROM devices where Number= ?1")
	Double priceSingle(int number);
	
	@Query("SELECT price_multi FROM devices where Number= ?1")
	Double priceMulti(int number);

	@Query("SELECT typereser FROM devices where Number= ?1")
	String typeRes(int number);
	
	@Query("SELECT idline FROM devices where number= ?1")
	Long devIdline(int number);
	
	@Query("SELECT count(status) FROM devices where status='Reserved'")
	int countDevRes();
	
	List<devices> findByStatus(String status);
	
	@Query("SELECT count(status) FROM devices where status!='Reserved'")
	int countEmpty();
	
	@Query("SELECT count(number) FROM devices")
	int countDev();
	
	@Query("select max(number) from devices ")
	int getNumDevic();
}
