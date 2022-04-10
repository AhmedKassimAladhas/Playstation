package com.aladhas.playstation;





import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;




@Controller
@SessionAttributes("name")
public class HomeController {

	
	
	@RequestMapping("/")
	
	public ModelAndView start() {
		ModelAndView mv = new ModelAndView("hello");
		//mv.addObject("name", "out");
		return mv;
	}; 
	
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		//mv.addObject("name", "out");
		
			
		return mv;
	};
	
	
	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView("hello");
		//mv.addObject("name", "out");
		return mv;
	};
}
