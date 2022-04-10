package com.aladhas.playstation;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.aladhas.playstation.service.DevicesServiceImpl;
import com.aladhas.playstation.model.devices;

@Controller
@SessionAttributes("name")
public class DevicesController {

	@Autowired
	private DevicesServiceImpl serv;
	
	@RequestMapping("/devices")
	public ModelAndView devices(Map<String, Object> m, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		List<devices> listDV = serv.listDevice(); 
		mv.addObject("listDV", listDV);
		int num = serv.getNumDevic();
		devices dv = new devices();
		m.put("device", dv);
		m.put("num", num + 1);
		
		String name = null;
		name =  (String) session.getAttribute("name");	
		System.out.println("...." + name);
		if(name == null ) {
			mv.setViewName("hello");
		}else {
			mv.setViewName("devices");
		}
		return mv;
	};
	
	@RequestMapping("/saveDV")
	public String saveDV(@ModelAttribute("device") devices device) {
		serv.addDV(device);
		return "redirect:/devices";
	}
	
	@RequestMapping("/editDV")
	public ModelAndView getDevices(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("edit_devices");		
		devices dv = serv.getDV(id);
		mv.addObject("device", dv);
		return mv;
	}
	
	@RequestMapping("/updateDV")
	public String updateDV(@RequestParam("id") Long id,@RequestParam("typeps")String type,@RequestParam("number") int number,@RequestParam("price_single") Double price_single,@RequestParam("price_multi") Double price_multi) {
		serv.updateDV(id, type, number, price_single, price_multi);
		return "redirect:/devices";
	}
	
	@RequestMapping("/deleteDV")
	public String deleteDV(@RequestParam("id") Long id) {
		serv.deleteDV(id);
		return "redirect:/devices";
	}
}
