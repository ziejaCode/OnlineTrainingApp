package application.controllers;
import java.util.Optional;

import org.springframework.stereotype.Controller;
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
    
    @RequestMapping("/all")
	public @ResponseBody Iterable<User> getAllUsers() {	    	
		return userService.getAllUsers();
	}    
    
    @RequestMapping("/oneU")
	public @ResponseBody Optional<User> getUser() {
    	
		Optional<User> user = userService.getUserById(6);
		
		System.out.println("...");
		System.out.println("Connecting...all " + user.get());
		System.out.println("...");
				
		return user;
	}

	//	save user
	    
	//  delete user
	    
	//  update user
	
	
	
	
	
}