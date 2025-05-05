package springmvc.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import springmvc.model.User;
import springmvc.service.UserService;

@Controller 
public class ContactController {
	
	@Autowired(required = true)
	private UserService userService;
	
	@ModelAttribute
	public void commonDataForModel(Model m) {
		m.addAttribute("Header", "LearnCodeWith Durgesh");
		m.addAttribute("Desc","Home for Programmer");
		System.out.println("adding command data to model");
	}
	
	@RequestMapping("/contact")
	public String showForm(Model m){
		System.out.println("Creating form");
		return "contact";
	}
	@RequestMapping(path ="/processform",method =RequestMethod.POST)
	public String handleForm(@ModelAttribute User user, Model model){
		
		System.out.println(user);
		
		if (user.getUserName().isBlank()) {
			return "redirect:/contact";
		}
		
		int result = userService.createUser(user);
		System.out.println(result);
		model.addAttribute("msg","User created with id"+result);
		return "success";
	}

}



//request param use

/*
 * @RequestMapping(path ="/processform",method =RequestMethod.POST) public
 * String handleForm(
 * 
 * @RequestParam(name = "email", required = false) String userEmail,
 * 
 * @RequestParam("userName") String userName,
 * 
 * @RequestParam("password") String userPassword, Model model){
 * 
 * 
 * User user=new User(); user.setEmail(userEmail); user.setUserName(userName);
 * user.setPassword(userPassword);
 * 
 * System.out.println(user);
 * 
 * 
 * //process
 * 
 * //model.addAttribute("name", userName); //model.addAttribute("email",
 * userEmail); //model.addAttribute("password", userPassword);
 * 
 * model.addAttribute("user",user); return "success"; }
 * 
 * }
 * 
 */