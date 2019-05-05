package application.controllers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import application.commands.UserCommand;
import application.model.User;
import application.services.UserService;
import ch.qos.logback.core.status.Status;

public class TrainingControllerTest {

	@Mock
	UserService userService;
	
	TrainingController trainingController;
	
	MockMvc mockMvc;
	
	@Before
	public void createUserController() throws Exception {		
				
		MockitoAnnotations.initMocks(this);		
		trainingController = new TrainingController(userService);
		mockMvc = MockMvcBuilders.standaloneSetup(trainingController).build();
	}
	
	@Test
	public void testListTraining() throws Exception{
		
		//UserCommand userCommand = new UserCommand();
		User user = new User();
		
		when(userService.getUserByUserId(anyInt())).thenReturn(user);
		
		mockMvc.perform(get("/training/6/showTrainings"))
			.andExpect(status().isOk())
			.andExpect(view().name("training/showTrainings"))
			.andExpect(model().attributeExists("user"));
		
		verify(userService, times(1)).getUserByUserId(6);
	}
	
	
	
	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public final void testTrainingController() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	public final void testGetAllUsers() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	public final void testGetTraining() {
//		fail("Not yet implemented"); // TODO
//	}

}
