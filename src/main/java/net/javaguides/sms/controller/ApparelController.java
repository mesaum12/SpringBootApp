package net.javaguides.sms.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.javaguides.sms.entity.Apparel;
import net.javaguides.sms.service.ApparelService;

@Controller
//@RequestMapping("/admin")
public class ApparelController {
	
	
	public static String uploadDir=System.getProperty("user.dir")+"/src/main/resources/templates";
	private ApparelService apparelService;

	public ApparelController(ApparelService apparelService) {
		super();
		this.apparelService = apparelService;
	}
	
	// handler method to handle the list of apparels
	@GetMapping("/admin/apparels")
	public String listApparels(Model model) {
		model.addAttribute("apparels", apparelService.getAllApparels());
		return "apparels";
	}
	
//	@GetMapping("/apparels/shop")
//	public String listAllApparels(Model model) {
//		model.addAttribute("apparels", apparelService.getAllApparels());
//		return "shop";
//	}
//	@GetMapping("/apparels/newArrivals")
//	public String listAllApparelsWithNewArrivals(Model model) {
//		model.addAttribute("apparels", apparelService.getAllNewArrivals());
//		return "shop";
//	}
	
	//create new apparel by the admin
	@GetMapping("/admin/apparels/new")
	public String createApparelForm(Model model) {
		
		Apparel apparel = new Apparel();
		model.addAttribute("apparel", apparel);
		return "create_apparel";
		
	}
	
	//the earlier version which was correct
//	@PostMapping("/admin/apparels")
//	public String saveApparel(@ModelAttribute("apparel") Apparel apparel) {
//		
//		
//		//before adding the apparel , we need to set the apparel image name of the apparel 
//		//here so that it can be displayed to the user on the frontend.
//		apparelService.saveApparel(apparel);
//		return "redirect:/admin/apparels";
//	}
	
	@PostMapping("/admin/apparels")
	public String saveApparel(@ModelAttribute("apparel") Apparel apparel,@RequestParam("productImage") 
	MultipartFile file,@RequestParam("imageName") String imageName) throws IOException {
		
		String imageUUID;
		Path currentpath =Paths.get(".");
		Path absolutePath=currentpath.toAbsolutePath();
		String finalPath=absolutePath+"/src/main/resources/static/photos/";
		System.out.print("Here");
		
		if(!file.isEmpty())
		{
			imageUUID=file.getOriginalFilename();
//			System.out.print("I m here 2:"+imageUUID);
			Path fileNameAndPath=Paths.get(finalPath+imageUUID);
//			System.out.print("I m here 2:"+fileNameAndPath);
			Files.write(fileNameAndPath,file.getBytes());
		}
		else
		{
			imageUUID=imageName;
		}
		apparel.setImageName(imageUUID);
		System.out.print("hello");
		//before adding the apparel , we need to set the apparel image name of the apparel 
		//here so that it can be displayed to the user on the frontend.
		apparelService.saveApparel(apparel);
		return "redirect:/admin/apparels";
	}
	
	@GetMapping("/admin/apparels/edit/{id}")
	public String editApparelForm(@PathVariable Long id, Model model) {
		model.addAttribute("apparel", apparelService.getApparelById(id));
		return "edit_apparel";
	}


	@PostMapping("/admin/apparels/{id}")
	public String updateApparel(@PathVariable Long id,
			@ModelAttribute("apparel") Apparel apparel,
			Model model) {
		
		// get student from database by id
		Apparel existingApparel = apparelService.getApparelById(id);
		existingApparel.setId(id);
		existingApparel.setFirstName(apparel.getFirstName());
		existingApparel.setPrice(apparel.getPrice());
		existingApparel.setGender(apparel.getGender());
		
		// save updated student object
		apparelService.updateApparel(existingApparel);
		return "redirect:/admin/apparels";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/admin/apparels/{id}")
	public String deleteApparel(@PathVariable Long id) {
		apparelService.deleteApparelById(id);
		return "redirect:/admin/apparels";
	}
	
	
	
	
//	 @GetMapping("/search")
//	 public String home(Model model,String keyword) {
//		 
//	  model.addAttribute("apparels", apparelService.getAllApparels());
//     System.out.print("Inside the home string method in controlelr");
//	  System.out.print(keyword);
//	  if(keyword!=null) {
//		  
//		  model.addAttribute("apparels", apparelService.getApparelsByKeyword(keyword));
//		  System.out.print("\nSuccess in finding keyword");
//		  
//	  }else {
//		  model.addAttribute("apparels", apparelService.getAllApparels());
//	  }
//	  return "shop";
//	 }
	   
}
	 
	
	  
