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

	
	private final TrainingService trainingService;    

    public TrainingController(TrainingService trainingService) {
		this.trainingService = trainingService;
	}
	
    @RequestMapping("/allT")
	public @ResponseBody Iterable<Training> getAllUsers() {	    	
		return trainingService.getAllTrainings();
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
	
	
	@RequestMapping("/oneT")
	public @ResponseBody Optional<Training> getTraining() {
		// This returns a JSON or XML with the users
		Optional<Training> training = trainingService.getTrainingById(5);
		
		System.out.println("...");
//		System.out.println("Connecting...all " + trainings.get(0).getTrainingName());
		System.out.println("...");
		
		
		return training;
	}
}
