package springmvc.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
   
	@RequestMapping("/home")
	public String home(Model model)
	{
		System.out.println("this is home url");
		model.addAttribute("name","Rahul Baghel");
		model.addAttribute("id",1421);
		
		List<String> friends=new ArrayList<String>();
		friends.add("vandan");
		friends.add("roshni");
		friends.add("ABC");
		
		model.addAttribute("f",friends);
		
		
		return "index";
	}
	
	@RequestMapping("/about")
	public String about() {
		System.out.println("this is about controller");
		return "about";
	}
	//services
	//help
	@RequestMapping("/help")
	public ModelAndView help()
	{
		System.out.println("this is help controller");
		
		//creating model and view object
		ModelAndView modelAndView=new ModelAndView();
		
		//setting the data
		modelAndView.addObject("name","Uttamshukla");
		modelAndView.addObject("rollnumber",123414);
		LocalDateTime now  = LocalDateTime.now();
		modelAndView.addObject("time", now);
		
		//marks
		List<Integer> list=new ArrayList<Integer>();
		list.add(12);
		list.add(3434);
		list.add(2134);
		list.add(2345);
		
		modelAndView.addObject("marks",list);
		
		
		//setting the view name
		modelAndView.setViewName("help");
		
		
		return modelAndView;
	}
}
