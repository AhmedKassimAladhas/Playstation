package com.aladhas.playstation;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.aladhas.playstation.model.devices;
import com.aladhas.playstation.model.invoiceline;
import com.aladhas.playstation.model.users;
import com.aladhas.playstation.service.DevicesServiceImpl;
import com.aladhas.playstation.service.ShiftsServiceImpl;
import com.aladhas.playstation.service.UserServiceImpl;

@Controller
@SessionAttributes("name")
public class UserController {

	@Autowired
	private UserServiceImpl serv;

	@Autowired
	private ShiftsServiceImpl servF;
	
	@Autowired
	private DevicesServiceImpl servD;
	
	@RequestMapping("/login")
	public ModelAndView loginAction(@RequestParam("Username") String username,
			@RequestParam("Password") String password) {
		ModelAndView mv = new ModelAndView();
		users result = serv.validateUser(username, password);		
		
		Date d = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");						  
		String dateof = ft.format(d);
		System.out.println(dateof);
		String shiftNum ;
		if (result != null) {
			System.out.println(result.getId());
			
						
			shiftNum = servF.getShiftNum(dateof, result.getName());
			System.out.println(shiftNum);
			if(shiftNum != null) {			
			serv.editUser(Integer.parseInt(shiftNum), result.getId());
			}
			mv.addObject("name", result.getName());
			mv.addObject("id", result.getId());
			mv.setViewName("forward:/home");
			
		} else {
			mv.setViewName("index");
			mv.addObject("error", "! خطأ في اسم المستخدم وكلمة المرور");			
		}
		return mv;		
	};
	
	@RequestMapping("/employees")
	public ModelAndView employees(Map<String, Object> model, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		List<users> list = serv.listAll();
		mv.addObject("list", list);
		users user = new users();
		model.put("user", user);
		mv.addObject("n", user.getName());
		
		String name = null;
		name =  (String) session.getAttribute("name");	
		System.out.println("...." + name);
		if(name == null ) {
			mv.setViewName("hello");
		}else {
			mv.setViewName("employees");
		}
		
		return mv;
	};

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String add(@ModelAttribute("user") users user) {
		serv.addEmp(user);
		return "redirect:/employees";
	}

	@RequestMapping(value ="/edit")
	public ModelAndView edit(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("edit_emp");
		users user = serv.get(id);		
		 mv.addObject("user", user);
		 return mv;
	}
	
	@RequestMapping(value = "/update")
	public String update(@RequestParam("id") int id,@RequestParam("Name") String name,@RequestParam("Username") String username,@RequestParam("Password") String password,@RequestParam("Salary") Double salary) {
		serv.update(id, name, username,password, salary);
		return "redirect:/employees";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam int id) {
		serv.delete(id);
		return "redirect:/employees";
	}
	
	@RequestMapping("/home")
	public ModelAndView home(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		int Device = servD.countDev();
		int Res = servD.countDevRes();
		int Empty = servD.countEmpty();
		
		invoiceline line = new invoiceline();	    		
		mv.addObject("line", line);	
		List<devices> listDV = servD.listDeviceByStatus("Reserved"); 
		List<devices> listDVS = servD.listDeviceByStatus(" "); 
		mv.addObject("listDVR", listDV);
		mv.addObject("listDVS", listDVS);
		mv.addObject("Device", Device);
		mv.addObject("Res", Res);
		mv.addObject("Empty", Empty);
		
		Date d = new Date();
		
		mv.addObject("d", d);
		
		String name = null;
		name =  (String) session.getAttribute("name");	
		System.out.println("...." + name);
		if(name == null ) {
			mv.setViewName("hello");
		}else {
			mv.setViewName("home");
		}
		
		return mv;
	}
	
}