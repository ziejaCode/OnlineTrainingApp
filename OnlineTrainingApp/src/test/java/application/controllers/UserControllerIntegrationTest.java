package application.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.verification.WantedButNotInvoked;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;

import application.model.User;
import application.repositories.UserRepository;
import application.services.UserService;
import application.services.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;



@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UserControllerIntegrationTest {
	
	UserService userService;
	
	//@Autowired
	Model model = null;
	
	LoginController loginControl;	
	
	@Autowired
	UserRepository userRepository;
	
//	@Captor
//	ArgumentCaptor<Set<User>> argumentCaptor;
	
	@Before
	public void createUserController() throws Exception {		
				
//		MockitoAnnotations.initMocks(this);		
		
		//userService = new UserServiceImpl(userRepository);	
		
		loginControl = new LoginController(userService);
	}
	
	
//	@Test
//	public void testMVC() throws Exception {
//		
//		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(loginControl).build();
//		
//		mockMvc.perform(get("/user/showUser"))
//				.andExpect(status().isOk())
//				.andExpect(view().name("user/showUser"));
//	}
	
	
	@Test
	public void testGetUserByUserName() {
	
		
		
		String urlParh = loginControl.getIndividualUser("borek", model);
		
		User user = userService.getUserByUserName("borek");
		
		model.addAttribute("user", user);
		
		
		
		assertEquals("user/showUser", urlParh);
		assertEquals("gienia", user.getPassword());
		assertEquals(new Integer(7), user.getUser_id());
		assertNotNull(user);
		
	}
	
	//@Test
	public void test() {
		
		Set<User> userData = new HashSet<User>();
		
		User user = new User();	
		//user.setUser_name("Bolek");
		userData.add(user);	
		
		User user1 = new User();
		//user1.setUser_name("Ciaran");
		userData.add(user1);
		
		when(userService.getAllUsers()).thenReturn(userData);
		
//		@SuppressWarnings("unchecked")
//		ArgumentCaptor<Set<User>> argumentCaptor  = ArgumentCaptor.forClass(Set.class);
		
		String result = loginControl.getAllUsers(model);
		
		assertEquals("user/showUser", result);
		
		verify(userService,  times(2)).getAllUsers();
		
		verify(model, times(1)).addAttribute(eq("users"), anySet());
		
		
		
		//Set<User>setController = argumentCaptor.getValue();
		
		//verify(loginControl).getAllUsers(argumentCaptor.capture());
		
		//assertEquals(2, setController.size());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
