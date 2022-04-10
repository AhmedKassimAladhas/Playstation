package com.aladhas.playstation.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aladhas.playstation.model.users;

@Service
@Transactional
public class UserServiceImpl {

	@Autowired
	private UserService serv;

	public users validateUser(String username, String password) {
		return serv.findByUsername(username, password);
	}

	public List<users> listAll() {

		return serv.findAll();
	}

	public void addEmp(users user) {

		serv.save(user);
	}

	public users get(int id) {

		return serv.findById(id).get();
	}

	public void update(int id, String name, String username, String password, Double salary) {
		serv.update(id, name, username, password, salary);
	}

	public void delete(int id) {

		serv.deleteById(id);
	}

	public void editUser(int shift, int id) {
		serv.editUserShift(shift , id);
	}
	
	public int getMaxShift() {
		return serv.getMaxShift();
	}
	
	public Long getEmpId(String name) {
		return serv.getEmpId(name);
	}
}
