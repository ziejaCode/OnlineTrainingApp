package application.controllers;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import application.model.Training;
import application.model.User;
import application.services.UserService;


@Controller
public class LoginController {

	private final UserService userService;    

    public LoginController(UserService userService) {
		this.userService = userService;
	}
    
    @RequestMapping("/user/showUser")
	//public @ResponseBody Iterable<User> getAllUsers() {	
    public String getAllUsers(Model model) {
    	
    	
    	Set<User>users = userService.getAllUsers(); 
    	model.addAttribute("users", users);
    	
    	for(User u: users) {
    		System.out.println("Users name is " + u.getUser_name());
    	}
    	
		return "user/showUser";
	}    
    
    @RequestMapping("/user/showUser/id")
	public @ResponseBody Optional<User> getUser() {
    	
		Optional<User> user = userService.getUserById(6);
		
		System.out.println("...");
		System.out.println("Connecting...all " + user.get());
		System.out.println("...");
				
		return user;
	}

	//	save user
//    @RequestMapping("/product")
//    public String getProduct(){
//        return "redirect:/index";
//    }    
	//  delete user
	    
	//  update user
	
	
	
	
	
}