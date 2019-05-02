
package application.controllers;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.*;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.verification.WantedButNotInvoked;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;

import application.commands.UserCommand;
import application.converters.UserCommandToUser;
import application.converters.UserToUserCommand;
import application.model.User;
import application.repositories.UserRepository;
import application.services.UserService;
import application.services.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import static org.mockito.ArgumentCaptor.forClass;



//@RunWith(SpringRunner.class)
//@WebMvcTest(LoginController.class)
public class UserControllerUnitTest {

//	
//	@Autowired
//	MockMvc mockMvc;
	
	@Mock
	UserService userService;	
	
	@Mock
	Model model;
	
	//@InjectMocks
	LoginController loginControl;	
	
//	@Captor
//	ArgumentCaptor<User> argumentCaptor;
	
//	@Autowired
//	UserCommandToUser userCommandToUser;
//	
//	@Autowired
//	UserToUserCommand userToUserCommand;

	@Before
	public void createUserController() throws Exception {		
				
		MockitoAnnotations.initMocks(this);		
		//userService = new UserServiceImpl(userRepo, userCommandToUser, userToUserCommand);	
		
		loginControl = new LoginController(userService);
	}
	
	@Test
	public void getUsersPage() {
		
		Set<User>users = new HashSet<User>();
		
		User user1 = new User();
		user1.setUserName("Givie");
		users.add(user1);
		
		when(userService.getAllUsers()).thenReturn(users);		
		
		Set<User>usersReturned = userService.getAllUsers();		
		
		User userReturned = null;
		
		for(User u: usersReturned) {
			userReturned = u;			
		}
		
		assertEquals("Givie", userReturned.getUserName());			
		assertEquals("user/showUsers",loginControl.getAllUsers(model));
		
		verify(userService, times(3)).getAllUsers();
		verify(model, times(1)).addAttribute(eq("users"), anySet());
	
	}
	
	
	@Test
	public void getSingleUsersPage() {
		
		User user1 = new User();
		user1.setUserName("Givief");
		
		when(userService.getUserByUserName("Givief")).thenReturn(user1);

		User userReturned = userService.getUserByUserName("Givief");
		
		assertEquals("Givief", userReturned.getUserName());	
		//assertEquals("user/showUser",loginControl.getIndividualUser(anyString(),model));
		
		verify(userService, times(2)).getUserByUserName(anyString());
		verify(model, times(1)).addAttribute(eq("user"), any());
	}
	
		

	@Test
	public void testAddUser() throws Exception {
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(loginControl).build();
		
		mockMvc.perform(get("/user/showUsers"))
				.andExpect(status().isOk())
				.andExpect(view().name("user/showUsers"));
	}
	
	@Test
	public void testDeleteSingleUserByUserId() throws Exception {
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(loginControl).build();
		
		mockMvc.perform(get("/user/20/deleteById"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/user/showUsers"));
	}
	
	
	@Test  
	public void testDeleteSingleUserByUserName() throws Exception {
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(loginControl).build();
		
		mockMvc.perform(get("/user/hermannus/deleteByName"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/user/showUsers"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//////////////  to delete  ////////////////
	
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
		
//		String result = loginControl.getAllUsers(model);
//		
//		assertEquals("user/showUser", result);
//		
//		verify(userService,  times(2)).getAllUsers();
//		
//		verify(model, times(1)).addAttribute(eq("users"), anySet());
		
		
		
		//Set<User>setController = argumentCaptor.getValue();
		
		//verify(loginControl).getAllUsers(argumentCaptor.capture());
		
		//assertEquals(2, setController.size());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
