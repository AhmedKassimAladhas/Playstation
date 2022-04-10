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

import com.aladhas.playstation.model.dailyaccount;
import com.aladhas.playstation.service.DailyAccountServiceImpl;
import com.aladhas.playstation.service.ExpensesServiceImpl;
import com.aladhas.playstation.service.InvoiceServiceImpl;
import com.aladhas.playstation.service.UserServiceImpl;

@Controller
@SessionAttributes("name")
public class DailyAccountController {

	@Autowired
	private DailyAccountServiceImpl serv;

	@Autowired
	private UserServiceImpl servU;

	@Autowired
	private InvoiceServiceImpl servI;

	@Autowired
	private ExpensesServiceImpl servE;

	@RequestMapping("/endShift")
	public ModelAndView endShift(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Date d = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String dateof = ft.format(d);
		dailyaccount daily = new dailyaccount();
		mv.addObject("daily", daily);
		mv.addObject("dateof", dateof);

		int shiftNum = servU.getMaxShift();
		mv.addObject("shiftNum", shiftNum);

		List<dailyaccount> list = serv.listAll();
		mv.addObject("listEn", list);

		String emp = (String) session.getAttribute("name");
		Double invototal = servI.gettotalInvo(dateof, emp);
		System.out.println("...." + invototal);
		Double exp = servE.getExp(dateof, emp);
		Double total = invototal;
		if (invototal != null) {
			if (exp != null) {
				total = invototal - exp;
			} else {
				exp = 0.0;
			}
		} else {
			invototal = 0.0;
			exp = 0.0;
			total = 0.0;
		}
		mv.addObject("invototal", invototal);
		
		mv.addObject("exp", exp);
		System.out.println(exp);
		mv.addObject("total", total);
		
		String name = null;
		name =  (String) session.getAttribute("name");	
		System.out.println("...." + name);
		if(name == null ) {
			mv.setViewName("hello");
		}else {
			mv.setViewName("endShift");
		}
		return mv;
	}

	@RequestMapping("/saveEn")
	public String saveEn(@ModelAttribute("daily") dailyaccount daily) {
		serv.saveDaily(daily);
		return "redirect:/endShift";
	}

	@RequestMapping("/deleteEn")
	public String deleteEn(@RequestParam("id") Long id) {
		serv.deleteDaily(id);
		return "redirect:/endShift";
	}

}
