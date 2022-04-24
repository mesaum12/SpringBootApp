package net.javaguides.sms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import net.javaguides.sms.service.ApparelService;

@Controller
public class UserController {

	
	private ApparelService apparelService;

	public UserController(ApparelService apparelService) {
		super();
		this.apparelService = apparelService;
	}

	
	//the main shopping page visible to the user
	@GetMapping("/user/apparels/shop")
	public String listAllApparels(Model model) {
		model.addAttribute("apparels", apparelService.getAllApparels());
		return "shop";
	}
	
	//page visible to the user on clicking the newArrivals
	@GetMapping("/apparels/newArrivals")
	public String listAllApparelsWithNewArrivals(Model model) {
		model.addAttribute("apparels", apparelService.getAllNewArrivals());
		return "shop";
	}
	
	//search functionality by the users 
	@GetMapping("/search")
	 public String home(Model model,String keyword) {
		 
	  model.addAttribute("apparels", apparelService.getAllApparels());
	  System.out.print("Inside the home string method in controller");
	  System.out.print(keyword);
	  if(keyword!=null) {
		  
		  model.addAttribute("apparels", apparelService.getApparelsByKeyword(keyword));
		  System.out.print("\nSuccess in finding keyword");
		  
	  }else {
		  model.addAttribute("apparels", apparelService.getAllApparels());
	  }
	  return "shop";
	 }
	
//	@GetMapping("/preferences")
//	public String process(Model model, HttpSession session) {
//		@SuppressWarnings("unchecked")
//		List<Apparel> apparels = (List<Apparel>) session.getAttribute("MY_SESSION_MESSAGES");
//
//		if (apparels == null) {
//			apparels = new ArrayList<>();
//		}
//		model.addAttribute("sessionMessages", apparels);
//		return "index";
//	}
//
//	@PostMapping("/shop/like/{id}")
//	public String persistMessage(@PathVariable long id,HttpServletRequest request) {
//		
//		System.out.print("called the persistMessage method , id is:"+id);
////		@SuppressWarnings("unchecked")
////		List<Apparel> apparels = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
////		if (messages == null) {
////			messages = new ArrayList<>();
////			request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
////		}
////		messages.add(msg);
////		request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
//		return "shop";
//	}
//
//	@PostMapping("/destroy")
//	public String destroySession(HttpServletRequest request) {
//		request.getSession().invalidate();
//		return "redirect:/";
//	}
	
	
}
