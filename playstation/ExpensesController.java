package com.aladhas.playstation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.aladhas.playstation.model.expenses;
import com.aladhas.playstation.service.ExpensesServiceImpl;

@Controller
@SessionAttributes("name")
public class ExpensesController {

	@Autowired
	private ExpensesServiceImpl serv;

	@RequestMapping("/expens")
	public ModelAndView expens(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Date d = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");						  
		String dateof = ft.format(d);
		expenses exp = new expenses();
		List<expenses> list = serv.getExpens();
		mv.addObject("listEX", list);
		mv.addObject("exp", exp);
		mv.addObject("date", dateof);

		String name = null;
		name =  (String) session.getAttribute("name");	
		System.out.println("...." + name);
		if(name == null ) {
			mv.setViewName("hello");
		}else {
			mv.setViewName("expens");
		}
		return mv;
	} 

	@RequestMapping("/saveEX")
	public String saveExp(@ModelAttribute("exp") expenses expens) {
		serv.addExpens(expens);
		return "redirect:/expens";
	}

	@RequestMapping("/deleteEX")
	public String deleteExp(@RequestParam("id") Long id) {
		serv.deleteExpens(id);
		return "redirect:/expens";
	}
}
