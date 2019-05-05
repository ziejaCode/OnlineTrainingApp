package application.controllers;

import java.io.IOException;
import java.lang.reflect.Type;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import application.model.Training;
import application.model.User;
import application.repositories.TrainingRepository;
import application.services.TrainingService;
import application.services.UserService;



@Controller
public class TrainingController {

	
//	private TrainingService trainingService;    

	private final UserService userService; 
	
//    public TrainingController(TrainingService trainingService) {
//		this.trainingService = trainingService;
//	}
    
//	public TrainingController(TrainingService trainingService) {
//		this.trainingService = trainingService;
//	}
	
	public TrainingController(UserService userService) {
		this.userService = userService;
	}
	
//    @RequestMapping("/allT")
//	public @ResponseBody Iterable<Training> getAllUsers() {	    	
//		return trainingService.getAllTrainings();
//	}    
	
	
	@RequestMapping("user/{id}/trainings")
	public String getAllTrainings(@PathVariable Integer id,  Model model ) {
		
		//System.out.println("Jestem w new " + userService.getUserByUserId(id));
		
		model.addAttribute("user", userService.getUserByUserId(id));
		
		return "user/training/trainings";
	}
	
	@RequestMapping("training/{id}/training")
	public String getTraining(@PathVariable Integer id,  Model model ) {
		
		//System.out.println("Jestem w new " + userService.getUserByUserId(id));
		
		User user = userService.getUserByUserId(id);
		
		//Training training = 
		
//		model.addAttribute("training", userService.getUserByUserId(id));
		
		return "user/training/training";
	}
	
	
//	@Autowired 
//	private TrainingRepository trainingRepository;
//	
//	@RequestMapping("/allT")
//	public @ResponseBody Iterable<Training> getAllTrainings() {
//		// This returns a JSON or XML with the users
//		List<Training>trainings;
//		trainings = (List<Training>) trainingRepository.findAll();
//		
//		System.out.println("...");
////		System.out.println("Connecting...all " + trainings.get(0).getTrainingName());
//		System.out.println("...");
//		
//		
//		return trainings;
//	}
	
	
//	@RequestMapping("/oneT")
//	public @ResponseBody Optional<Training> getTraining() {
//		// This returns a JSON or XML with the users
//		Optional<Training> training = trainingService.getTrainingById(5);
//		
//		System.out.println("...");
////		System.out.println("Connecting...all " + trainings.get(0).getTrainingName());
//		System.out.println("...");
//		
//		
//		return training;
//	}
}
