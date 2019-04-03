package application.controllers;

import java.security.Principal;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import application.model.User;



//import model.User;

@Controller
//@RequestMapping(path="")
public class HomeController {
	
//	@Autowired
//	private UserRepository userRepository;
	
	
//	private static Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping({"/","/index" })
	public  String showWelcomePage(){		
//		logger.info("Showing welcome page");
		System.out.println("...");
		System.out.println("Connecting...welcome");
		System.out.println("...");
		return "index";		
	}
	
	@RequestMapping("/guestPage")
	public @ResponseBody String showOptions(Model model){
//		logger.info("Showing guest page");
		return "guestPage";
	}
	
//	@RequestMapping("/homePage")
//	public @ResponseBody String showHomePage(Model model, Principal principal){				
////		logger.info("Showing home page");
//		//String username = principal.getName();
//		
//		User user = new User();
//		user.setName("Roman");
//		
//		model.addAttribute("user", user);
//		
//		System.out.println("user name is " + user.getName());
//		
//		return "Welcome " + user.getName() ;
//	}
	
	@RequestMapping("/about")
	public String showAboutPage(Model model){				
		return "about";
	}
	
	
	@RequestMapping("/contact")
	public String showContactPage(Model model){				
		return "contact";
	}
	
}
