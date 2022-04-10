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
import com.aladhas.playstation.model.drinks;
import com.aladhas.playstation.model.invoice;
import com.aladhas.playstation.model.invoiceline;
import com.aladhas.playstation.model.reservation;
import com.aladhas.playstation.service.DevicesServiceImpl;
import com.aladhas.playstation.service.DrinkServiceImpl;
import com.aladhas.playstation.service.InvoiceServiceImpl;
import com.aladhas.playstation.service.InvoicelineServiceImpl;
import com.aladhas.playstation.service.ReservationServiceImpl;



@Controller
@SessionAttributes("name")
public class ReservationController {

	@Autowired
	private ReservationServiceImpl serv;
	
	@Autowired
	private DevicesServiceImpl servD;
	
	@Autowired
	private InvoiceServiceImpl servI;
	
	@Autowired
	private DrinkServiceImpl servDR;
	
	@Autowired
	private InvoicelineServiceImpl servIL;
	
	
	@RequestMapping("/reservation")
	public ModelAndView reservation(Map<String, Object> model, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		List<devices> listDV = servD.listDevice(); 
		mv.addObject("listDV", listDV);

		devices device = new devices();
		model.put("device", device);						
		 
		invoiceline line = new invoiceline();	    		
		mv.addObject("line", line);		
		
		reservation res = new reservation();
		mv.addObject("res", res);
		
		Date d = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("HH:mm:ss");						
		mv.addObject("tim",  ft.format(d));	 
		
		invoice inv = new invoice();
		mv.addObject("inv", inv);	
		
		String name = null;
		name =  (String) session.getAttribute("name");	
		System.out.println("...." + name);
		if(name == null ) {
			mv.setViewName("hello");
		}else {
			mv.setViewName("reservation");
		}
		
		return mv;
	};				
	
	@RequestMapping("/getD")
	public ModelAndView getDe(@RequestParam("devicenum") Long id) {
		ModelAndView mv = new ModelAndView();		
		devices dv = servD.getDV(id);
		mv.addObject("dev", dv);
		reservation res = new reservation();
		mv.addObject("res", res);
		 
		Date d = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("HH:mm:ss");		
		SimpleDateFormat f = new SimpleDateFormat ("yyyy-MM-dd");
		mv.addObject("time", ft.format(d));
		mv.addObject("date", f.format(d));

		Long numRes =  serv.numberRes();		
		if(numRes == null) {
			mv.addObject("num", "1");
		}else {
			mv.addObject("num", numRes);
		}
		Long Res =  servD.getMaxNum(id);
		if(Res==0) {
			mv.setViewName("startTime");
		}else {
			 mv.setViewName("redirect:/reservation");
		}
		return mv;
	}
	
	@RequestMapping("/start")
	public String resNew(@ModelAttribute("res") reservation res,@ModelAttribute("inv") invoice inv,@ModelAttribute("line") invoiceline line,@RequestParam("devicenum") int id,@RequestParam("resfrom") String start,@RequestParam("typeofres") String typereser,@RequestParam("number") int numberres,@RequestParam("drinktotal") Double drinktotal) {
		String status = "Reserved";	
		serv.addReservation(res);	
		servI.addInv(inv);		
		servIL.addLine(line);
		int idline = servIL.getMaxId();
		servD.updateDVR(status, start,numberres,idline,typereser, id);		
		return "redirect:/reservation";
	}		
	
	@RequestMapping("/AddDrink")
	public String pric(Map<String, Object> model,@RequestParam("number") Long number) {
		invoiceline line = new invoiceline();		
		model.put("line", line);		
		List<drinks> dr = servDR.listDrink();
		model.put("listDR", dr);
		Long numRes =  servD.getMaxNum(number);
		model.put("numb", numRes);
		model.put("DevNum", number);
		String drink = servD.getMaxDrink(number);
		if(numRes!=0 & drink.equalsIgnoreCase("")) {
			return "addDrink";
		}else{
			return "redirect:/reservation";
		}		
	}
	
	@RequestMapping("/addDr")
	public String newDrink(@ModelAttribute("line") invoiceline line,@RequestParam("drinkt") String DrinkT,@RequestParam("drinkcount") int DrinkCount,@RequestParam("number") int number,@RequestParam("devicenum") int devicenum) {
		String drink = "Yes";
		servD.drinkR(drink, number);		
		System.out.println(".."+DrinkT);		
		Double DrinkPrice =servDR.getPriceD(DrinkT);
		System.out.println("..."+DrinkPrice);
		Double Drinktotal = DrinkCount * DrinkPrice;
		System.out.println("...."+DrinkCount);
		servIL.editDrink(DrinkT, DrinkPrice, DrinkCount,Drinktotal, number,devicenum);
		return "redirect:/reservation";
	}
	
	@RequestMapping("/EditDrink")
	public String editDr(Map<String, Object> model,@RequestParam("number") Long number) {
		invoiceline line = new invoiceline();		
		model.put("line", line);		
		List<drinks> dr = servDR.listDrink();
		model.put("listDR", dr);
		Long numRes =  servD.getMaxNum(number);
		model.put("numb", numRes);
		String drink = servD.getMaxDrink(number);
		if(numRes!=0 & drink.equalsIgnoreCase("Yes")) {
			return "addDrink2";
		}else{
			return "redirect:/reservation"; 
		}				
	}
	
	@RequestMapping("/addDr2")
	public String newDrink2(@ModelAttribute("line") invoiceline line,@RequestParam("drinkt") String DrinkT,@RequestParam("drinkcount") int DrinkCount,@RequestParam("number") int number) {
		System.out.println(".."+DrinkT);		
		Double DrinkPrice =servDR.getPriceD(DrinkT);
		System.out.println("..."+DrinkPrice);
		Double Drinktotal = DrinkCount * DrinkPrice;
		System.out.println("...."+DrinkCount);
		line.setDrinkprice(DrinkPrice);
		line.setDrinktotal(Drinktotal);
		line.setTotal(Drinktotal);
		int devNum = servD.getDevNum(number);
		line.setDevicenum(devNum);
		String drink = "Yes";
		servD.drinkR(drink, number);		
		servIL.addLine(line);
		return "redirect:/reservation";
	}
			
	@RequestMapping("getconvert")
	public String getconv(Map<String, Object> model,@RequestParam("devicenum") int number) {
		Date d = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("HH:mm:ss");		
		model.put("time", ft.format(d));
		
		List<devices> listDV = servD.listDevice(); 
		model.put("listDV", listDV);
		invoiceline line = new invoiceline();
		model.put("line", line);
		
		Long Res =  servD.getMaxNum(Long.valueOf(number));
		
		String typeOf = servD.getTypeRes(number);
		System.out.println(typeOf);		
		
		if(typeOf.equals("multi")) {
			System.out.println("15");
			model.put("price", servD.getPriceMulti(number));
		}else{
			System.out.println("10");
			model.put("price", servD.getPriceSingle(number));
		}
		
		model.put("invo", Res);
		if(Res!=0) {
			return "convertDevice";
		}else {
			return "redirect:/reservation";
		}		 
	}
	
	@RequestMapping("/convert")
	public String convertDevice(@ModelAttribute("line") invoiceline line,@RequestParam("price") Double price, @RequestParam("typeofres") String typer ,@RequestParam("devicenum") int devic ,@RequestParam("resfrom") String tim,@RequestParam("drinktotal") Double drinktotal ,@RequestParam("number") int id) {
		int num =  servD.getDevNum(id);						
		servIL.addLine(line);		
		
		String star = servD.getMaxStart(num);
		String end = tim;		
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		Date d1;
		Date d2;
		long diff;
		try {
			d1 = format.parse(star);
			d2 = format.parse(end);		
			diff = d2.getTime() - d1.getTime();			
			long diffSeconds,diffMinutes,diffHours;
			 if (diff > 0) {
				 diffSeconds = diff / 1000 % 60;
				 diffMinutes = diff / (60 * 1000) % 60;
				 diffHours = diff / (60 * 60 * 1000);				 
			 }
				 else{
				 long diffpos = (24*((60 * 60 * 1000))) + diff;
				 diffSeconds = diffpos / 1000 % 60;
				 diffMinutes = diffpos / (60 * 1000) % 60;
				 diffHours = (diffpos / (60 * 60 * 1000));
				 }			 
			 String tot = String.valueOf(diffHours+":"+diffMinutes+":"+diffSeconds);
			 
			 Double priceTotal;
			 priceTotal = price * diffHours;
			 if(diffMinutes > 20 || diffHours == 0) 
			 priceTotal += price;
			  Long idLine = servD.getDevIdline(num);
			  
			  	double Drinktotal = servIL.getDrinkTotal(idLine);
				double total;
				if(Drinktotal != 0) {
					total = priceTotal + Drinktotal; 
				}else {
					total = priceTotal;
				}
			  
			 servIL.endTime(tim, star,tot,priceTotal,total,idLine);
		}catch(Exception ex) {
			
		}							 			 					 			 
			
		String statu = "Reserved";	
		int idlin = servIL.getMaxId();
		servD.updateDVR(statu, tim,id,idlin,typer, devic);
						
		String status = "";	
		String start = "";
		int numberres = 0;
		int idline = 0;
		String drink = "";
		String typereser = "";
		servD.drinkDelet(drink, num);
		servD.updateDVR(status, start,numberres,idline,typereser, num);
				
		return "redirect:/reservation";	
	}
	
	@RequestMapping("/convertType")
	public String convertType(@ModelAttribute("line") invoiceline line,@RequestParam("devicenum") int devic,@RequestParam("drinktotal") Double drinktotal,@RequestParam("number") int number ) {
		if(number != 0) {
			servIL.addLine(line);	
			line.setDrinkt(null);
			
			Double price;
			String typeOf = servD.getTypeRes(devic);
			System.out.println(typeOf);							
			if(typeOf.equals("multi")) {
				System.out.println("15");
				price = servD.getPriceMulti(devic);
			}else{
				System.out.println("10");
				price = servD.getPriceSingle(devic);
			}
		
			Date d = new Date();
			SimpleDateFormat ft = new SimpleDateFormat ("HH:mm:ss");						  
			String star = servD.getMaxStart(devic);
			String end = ft.format(d);		
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			Date d1;
			Date d2;
			long diff;
		
			Double priceTotal;
			String totalTime;		
			try {
				d1 = format.parse(star);
				d2 = format.parse(end);
				diff = d2.getTime() - d1.getTime();
						
				long diffSeconds,diffMinutes,diffHours;
				if (diff > 0) {
					diffSeconds = diff / 1000 % 60;
					diffMinutes = diff / (60 * 1000) % 60;
					diffHours = diff / (60 * 60 * 1000);				 
				}
				 else{
					 long diffpos = (24*((60 * 60 * 1000))) + diff;
					 diffSeconds = diffpos / 1000 % 60;
					 diffMinutes = diffpos / (60 * 1000) % 60;
					 diffHours = (diffpos / (60 * 60 * 1000));
				 }			 

				totalTime = String.valueOf(diffHours+":"+diffMinutes+":"+diffSeconds);			 			 				
				priceTotal = price * diffHours;
				if(diffMinutes > 20 || diffHours == 0) { 
					priceTotal += price;
				}

				Long idLine =   servD.getDevIdline(devic);
				System.out.println(".........."+ idLine);
				
				double Drinktotal = servIL.getDrinkTotal(idLine);
				double total;
				if(Drinktotal != 0) {
					total = priceTotal + Drinktotal; 
				}else {
					total = priceTotal;
				}
				
				servIL.endTime(end, star,totalTime,priceTotal,total,idLine);	 
			}catch(Exception ex) {
			
			}							 		
		
			String dv = servD.getTypeRes(devic);
			String typer;
			if(dv.equals("single")) 
			{
				typer = "multi";
			}else {
				typer = "single";
			}
			int maxId = servIL.getMaxId();
			servD.updateResType(end, typer,maxId, devic);
				
			servIL.editType(typer,end,Long.valueOf(maxId));			
		
			return "redirect:/reservation";		
	
			}else {		
			return "redirect:/reservation";
			}
	}	

	@RequestMapping("endTime")
	public String endTime(Map<String, Object> model,@RequestParam("devicenum") int id,@RequestParam("numberres") int numberres) {
		
		
//		if(num !=0) {
		Double price;
		String typeOf = servD.getTypeRes(id);
		System.out.println(typeOf);							
		if(typeOf.equals("multi")) {
			System.out.println("15");
			price = servD.getPriceMulti(id);
		}else{
			System.out.println("10");
			price = servD.getPriceSingle(id);
		}
		Date d = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("HH:mm:ss");						  
		String star = servD.getMaxStart(id);
		String end = ft.format(d);
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		Date d1;
		Date d2;
		long diff;
		try {
			d1 = format.parse(star);
			d2 = format.parse(end);		
			diff = d2.getTime() - d1.getTime();			
			long diffSeconds,diffMinutes,diffHours;
			 if (diff > 0) {
				 diffSeconds = diff / 1000 % 60;
				 diffMinutes = diff / (60 * 1000) % 60;
				 diffHours = diff / (60 * 60 * 1000);				 
			 }
				 else{
				 long diffpos = (24*((60 * 60 * 1000))) + diff;
				 diffSeconds = diffpos / 1000 % 60;
				 diffMinutes = diffpos / (60 * 1000) % 60;
				 diffHours = (diffpos / (60 * 60 * 1000));
				 }			 
			 String tot = String.valueOf(diffHours+":"+diffMinutes+":"+diffSeconds);
			 
			 Double priceTotal;
			 priceTotal = price * diffHours;
			 if(diffMinutes > 20 || diffHours == 0) 
			 priceTotal += price;
			  Long idLine = servD.getDevIdline(id);
			  
			  double Drinktotal = servIL.getDrinkTotal(idLine);
				double total;
				if(Drinktotal != 0) {
					total = priceTotal + Drinktotal; 
				}else {
					total = priceTotal;
				}
				
			 servIL.endTime(end, star,tot,priceTotal,total,idLine);
		}catch(Exception ex) {
			
		}
		
		invoice inv = new invoice();
		model.put("inv", inv);
		model.put("devicenum", id);
		model.put("numberres", numberres);
		List<invoiceline> line = servIL.getAllInvo(numberres);
		List<invoiceline> lineD = servIL.getAllInvoDrink(numberres);
		model.put("line", line);
		model.put("lineD", lineD);
		Double totalInvo = servIL.getTotalInvo(numberres);
		model.put("totalInvo", totalInvo);
		
		if(numberres !=0) {
			
			return "endTime";
		}else {
			return "redirect:/reservation";
		}
	}
	
	
	
	@RequestMapping(value="/print", method=RequestMethod.GET)
	 public ModelAndView printBill(@RequestParam("numberres") int numberres){
		ModelAndView mv = new ModelAndView();	  
		List<invoiceline> line = servIL.getAllInvo(numberres);
		List<invoiceline> lineD = servIL.getAllInvoDrink(numberres);
		Double totalInvo = servIL.getTotalInvo(numberres);
		mv.addObject("totalInvo", totalInvo);
		mv.addObject( "line", line);
		mv.addObject( "lineD", lineD);
		mv.addObject( "numberres", numberres);
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy -- hh:mm:ss");
		String date = format.format(d);
		mv.addObject( "date", date);
		mv.setViewName("printBill");
		return mv;
	 }
	
	@RequestMapping(value="/save", method=RequestMethod.GET)
	 public ModelAndView save(@RequestParam("empinv") String emp,@RequestParam("totalinv") Double total,@RequestParam("notes") String notes,@RequestParam("number") int number,@RequestParam("devicenum") int device){
		ModelAndView mv = new ModelAndView();	  
		servI.updateInvo(emp, total, notes, number);
		
		String status = "";	
		String start = "";
		int numberre = 0;
		int idline = 0;
		String drink = "";
		String typereser = "";
		servD.drinkDelet(drink, device);
		servD.updateDVR(status, start,numberre,idline,typereser, device);
		
		mv.setViewName("redirect:/reservation");
		return mv;
	 }
	    
}
