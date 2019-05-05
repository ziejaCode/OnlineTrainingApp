package application.controllers;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import application.commands.UserCommand;
import application.model.Training;
import application.model.User;
import application.repositories.UserRepository;
import application.services.TrainingService;
import application.services.UserService;


@Controller
public class LoginController {

	private final UserService userService;    

	//private final TrainingService trainingService;    
	
    public LoginController(UserService userService) {
		this.userService = userService;
	}
    
    @GetMapping
    @RequestMapping("/user/showUsers")
    public String getAllUsers(Model model) {	
    	
    	//Set<User>users = userService.getAllUsers(); 
    	model.addAttribute("users", userService.getAllUsers());    	
		return "user/showUsers";
	}    
    
    @GetMapping
    @RequestMapping("/user/{id}/showUser/")
    public String getIndividualUser(@PathVariable Integer id,  Model model ) {
    	
    	
    	
    	User user = userService.getUserByUserId(id);
    	
    	
    	
    	model.addAttribute("user", user);
    	return "user/showUser";
    }
    
    @GetMapping
    @RequestMapping("/user/new")
    public String newUser(Model model) { 
    	
    	model.addAttribute("user", new User());    	
    	return "user/newUser";
    }
    
    @PostMapping
    @RequestMapping("newUser")
    public String saveUser(@ModelAttribute UserCommand userCommand) { 
    	
    	System.out.println("Jestem w new ");
    	    	
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");    	
    	String date = df.format(new Date());
    	
    	userCommand.setAuthority("USER");
    	userCommand.setCreated(date);
    	    	
    	UserCommand savedUserCommand = userService.updateUser(userCommand);
    	
    	return "redirect:/user/" + savedUserCommand.getUser_id() + "/showUser/"; 	
    }
    
    
    
    
    
    @GetMapping
    @RequestMapping("/user/{id}/update")
    public String updateUser(@PathVariable Integer id, Model model) {
    	System.out.println("User to update is " + id);
    	User userToUpdate = userService.getUserByUserId(id);
    	model.addAttribute("user", userToUpdate);
    	return "user/updateUser";
    }
    
   
    
    
    
    
    
    
    
    @PostMapping
    @RequestMapping("updateUser")
    public String updateUser(@ModelAttribute UserCommand userCommand) { 
    	
    	System.out.println("Jestem w update ");
    	
    	if(userCommand.getCreated().equals("")) {
    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");    	
        	String date = df.format(new Date());
        	userCommand.setCreated(date);
    	}
    	
    	UserCommand savedUserCommand = userService.updateUser(userCommand);
    	
    	
    	return "redirect:/user/" + savedUserCommand.getUser_id() + "/showUser/"; 
    	
    }
    
    
    
    
    
    
    
    
    
    
//    @PostMapping
//    @RequestMapping("user")
//    public String saveUpdateUser(@ModelAttribute User user) {
//    	System.out.println("Updated that I will update right now is " + user.getUser_id());
//    	System.out.println("this user was created in " + user.getCreated());
//    	Date dateOfOriginalCreation = user.getCreated();
//    	if(!(dateOfOriginalCreation == null)) {
//    		user.setCreated(new Date());
//    	}else {
//    		user.setCreated(dateOfOriginalCreation);
//    	}
//    	
//    	User savedUser = userService.updateUser(user);
//    	System.out.println("Updated User is " + savedUser.getUser_id());
//    	return "redirect:/user/" + savedUser.getUser_id() + "/showUser";
//    }
    
   
    @GetMapping
    @RequestMapping("user/{id}/deleteById")
    public String deleteUserById(@PathVariable Integer id) {
    	System.out.println("User to delete is " + id); 
    	userService.deleteByUserId(id);    	
    	return "redirect:/user/showUsers";
    }
    
    @Transactional
    @GetMapping
    @RequestMapping("user/{name}/deleteByName")
    public String deleteUserByUserName(@PathVariable String name) {    	 
    	userService.deleteByUserName(name);    	
    	return "redirect:/user/showUsers";
    }
    
    
    public String deleteAllUsers() {
    	userService.deleteAllUsers();
    	return "All users removed";
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