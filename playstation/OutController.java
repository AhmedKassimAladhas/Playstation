package com.aladhas.playstation;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aladhas.playstation.service.UserServiceImpl;

@Controller
public class OutController {

	@Autowired
	private UserServiceImpl servU;
	
	@RequestMapping("/Hello")
	public ModelAndView out(HttpSession session) {
		ModelAndView mv = new ModelAndView("hello");
		session.invalidate();		
		servU.editUser(0, servU.getMaxShift());
		return mv;
	}; 
}
