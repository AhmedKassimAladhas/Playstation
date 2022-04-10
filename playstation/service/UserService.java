package com.aladhas.playstation.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aladhas.playstation.model.users;

public interface UserService extends JpaRepository<users, Integer>{
	
	@Query("select u from users u where Username =  :Username  and Password =  :Password")
	  users findByUsername(@Param("Username") String username, @Param("Password") String password);
	
	@Modifying
	@Query("update users u set u.Name=:Name, u.Username=:Username, u.Password=:Password, u.Salary=:Salary where u.ID =:id")
	  void update(@Param("id") int id,@Param("Name") String name,@Param("Username") String username,@Param("Password") String password,@Param("Salary") Double salary);
	
	@Modifying
	@Query("update users u set u.shift= ?1 where u.ID =?2")
	  void editUserShift(int shift, int id);
	
	@Query("select max(shift) from users")
	  int getMaxShift();
	
	@Query("select ID from users where Name =?1")
	  Long getEmpId(String name);
	
}
