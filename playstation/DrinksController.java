package com.aladhas.playstation;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.aladhas.playstation.model.drinks;
import com.aladhas.playstation.service.DrinkServiceImpl;

@Controller
@SessionAttributes("name")
public class DrinksController {

	@Autowired
	private DrinkServiceImpl serv;
	
	@RequestMapping("/drinks")
	public ModelAndView listDrinks(Map<String, Object> m, HttpSession session) {
		ModelAndView mlv = new ModelAndView();
		
		List<drinks> listD = serv.listDrink();
		mlv.addObject("listD", listD);
		drinks drink = new drinks();
		m.put("drink", drink);
		
		String name = null;
		name =  (String) session.getAttribute("name");	
		System.out.println("...." + name);
		if(name == null ) {
			mlv.setViewName("hello");
		}else {
			mlv.setViewName("drinks");
		}
		return mlv;
	}
	
	@RequestMapping(value = "/saveD", method = RequestMethod.POST)
	public String addDrink(@ModelAttribute("drink") drinks drink) {
		serv.addDrink(drink);
		return "redirect:/drinks";
	}
	
	@RequestMapping("/editD")
	public ModelAndView getDrinks(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("edit_drinks");
		drinks drink = serv.getDrink(id);
		mv.addObject("drink", drink);
		return mv;
	}
	
	@RequestMapping("/updateD")
	public String editDrink(@RequestParam("id") Long id,@RequestParam("drinkType") String drinkType,@RequestParam("price") Double price,@RequestParam("notes") String notes) {
		serv.updateDrink(id, drinkType, price, notes);
		return "redirect:/drinks";
	}
	
	@RequestMapping("/deleteD")
	public String deleteDrink(@RequestParam("id") Long id) {
		serv.deleteDrink(id);
		return "redirect:/drinks";
	}
}
