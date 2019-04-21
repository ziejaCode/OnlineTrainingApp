package application.controllers;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import application.commands.UserCommand;
import application.model.Training;
import application.model.User;
import application.services.UserService;


@Controller
public class LoginController {

	private final UserService userService;    

    public LoginController(UserService userService) {
		this.userService = userService;
	}
    
    @RequestMapping("/user/showUsers")
	//public @ResponseBody Iterable<User> getAllUsers() {	
    public String getAllUsers(Model model) {    	
    	
    	Set<User>users = userService.getAllUsers(); 
    	model.addAttribute("users", userService.getAllUsers());
    	
    	for(User u: users) {
    		System.out.println("Users name is " + u.getUserName());
    	}
    	
		return "user/showUsers";
	}    
    
    @RequestMapping("/user/showUser/{name}")
    public String getIndividualUser(@PathVariable String name,  Model model ) {
    	
    	User user = userService.getUserByUserName(name);
    	//Optional<User> user = userService.getUserByUserName(name);
    	model.addAttribute("user", user);
    	
//    	System.out.println("...");
//		System.out.println("Provided " + name);
//		System.out.println("...");
    	
    	System.out.println("...");
		System.out.println("Connecting...all " + user);
		System.out.println("...");
    	
    	
    	return "user/showUser";
    }
    
    
    @RequestMapping("/user/new")
    public String newUser(Model model) {    	
    	model.addAttribute("user", new UserCommand());
    	return "user/newUser";
    }
    
    @PostMapping
    @RequestMapping("user")
    //public String saveUpdateUser(@ModelAttribute User user) {    	
    public String saveUpdateUser(@ModelAttribute UserCommand userCommand) { 	
    	
    	UserCommand savedUserCommand = userService.saveUserCommand(userCommand);
    	
    	return "redirect:/user/showUser/" + savedUserCommand.getUserName();
    }
    
    
    
    
    //pure testing purpose - to delete
    @RequestMapping("/testGetUsers")
	public @ResponseBody Iterable<User> getAllUsersData() {
    	
    	Set<User>users = userService.getAllUsers(); 
    	//model.addAttribute("users", users);
    	
    	for(User u: users) {
    		System.out.println("Users name is " + u.getUserName());
    	}
    	return users;
    	
		
	}    
    
    
//    @RequestMapping("/user/showUser/{id}")
//	public @ResponseBody Optional<User> getUser() {
//    	
//		Optional<User> user = userService.getUserById(6);
//		
//		System.out.println("...");
//		System.out.println("Connecting...all " + user.get());
//		System.out.println("...");
//				
//		return user;
//	}

	//	save user
//    @RequestMapping("/product")
//    public String getProduct(){
//        return "redirect:/index";
//    }    
	//  delete user
	    
	//  update user
	
	
	
	
	
}