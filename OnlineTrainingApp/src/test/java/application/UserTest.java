package application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.TestClass;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import application.controllers.LoginController;
import application.model.User;
import application.repositories.UserRepository;
import application.services.UserService;
import application.services.UserServiceImpl;

public class UserTest {

	UserService userService;
	
	@Mock
	UserRepository userRepository;
	
	@Before
	public void createUserService() throws Exception {
		
		MockitoAnnotations.initMocks(this);		
		userService = new UserServiceImpl(userRepository);		
	}
	
	
	@Test
	public void getUser() throws Exception {
		
		
		Optional<User> user =  userService.getUserById(6);	
		
		Set<User>users = userService.getAllUsers();
		assertEquals(users.size(), 0);
		
		System.out.println("\nUsers name is " + users.toString());
		
		
	}

}




