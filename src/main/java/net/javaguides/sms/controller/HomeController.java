package net.javaguides.sms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import net.javaguides.sms.entity.User;
import net.javaguides.sms.service.UserService;


@Controller
public class HomeController {
	
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	private UserService userService;
	
	public HomeController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@RequestMapping("/signup")
	public String signup(Model model)
	{
	   model.addAttribute("user",new User());
	   return "signup";
	  
	}
	
	@PostMapping("/do_register")
	public String registerUser(@ModelAttribute("user") User user,Model model)
	{
//		user.setEnabled(true);
		user.setRole("ROLE_USER");
//		user.setRole("ROLE_ADMIN");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.saveUser(user);
		return "signup";
	}
	
	//the base page is a signup page for the user 
	@GetMapping("/")
	public String homepage()
	{
		return "index";
	}
	

}
		
		 
		
		
		
		
		
		
	

	  
