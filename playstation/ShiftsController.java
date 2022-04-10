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

import com.aladhas.playstation.model.shifts;
import com.aladhas.playstation.model.users;
import com.aladhas.playstation.service.ShiftsServiceImpl;
import com.aladhas.playstation.service.UserServiceImpl;

@Controller
@SessionAttributes("name")
public class ShiftsController {

	@Autowired
	private ShiftsServiceImpl serv;
	@Autowired
	private UserServiceImpl userv;
	
	@RequestMapping("/shifts")
	public ModelAndView listShifts(Map<String, Object> m, HttpSession session){
		ModelAndView mv = new ModelAndView();
		List<shifts> listSH = serv.listShifts();
		List<users> list = userv.listAll();
		mv.addObject("listSH", listSH);
		mv.addObject("list", list);
		shifts shift = new shifts();
		m.put("shift", shift);
		
		String name = null;
		name =  (String) session.getAttribute("name");	
		System.out.println("...." + name);
		if(name == null ) {
			mv.setViewName("hello");
		}else {
			mv.setViewName("shifts");
		}
		return mv;
	}
	
	@RequestMapping(value = "/saveSH", method = RequestMethod.POST)
	public String saveShift(@ModelAttribute("shift") shifts shift) {
		serv.addShift(shift);
		return "redirect:/shifts";
	}
	
	@RequestMapping("/editSH")
	public ModelAndView getShifts(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("edit_shift");
		List<users> list = userv.listAll();
		mv.addObject("list", list);
		shifts shift = serv.getShift(id);
		mv.addObject("shift", shift);
		return mv;
	}
	
	@RequestMapping("/updateSH")
	public String updateShifts(@RequestParam("id") Long id,@RequestParam("number") int number,@RequestParam("dateofshift") String dateofshift,@RequestParam("shiftfrom") String shiftfrom,@RequestParam("shiftto") String shiftto,@RequestParam("emp") String emp,@RequestParam("notes") String notes) {
		serv.updateShift(id, number, dateofshift, shiftfrom, shiftto, emp, notes);
		return "redirect:/shifts";
	}
	
	@RequestMapping("/deleteSH")
	public String deleteShifts(@RequestParam Long id) {
		serv.deleteShift(id);
		return "redirect:/shifts";
	}
}
