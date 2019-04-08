package application.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

import application.model.User;
import application.repositories.UserRepository;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment=WebEnvironment.NONE)
public class UserServiceTest {

	//@Autowired
	UserService userService;
	
	
	@Mock
	UserRepository userRepository;
	
	@Before
	public void createUserService() throws Exception {		
				
		MockitoAnnotations.initMocks(this);		
		userService = new UserServiceImpl(userRepository);		
	}
	
	
	@Test
	public void getUsers() throws Exception {
		
		User user = new User();
		HashSet<User> userData = new HashSet();
		userData.add(user);
		
		when(userService.getAllUsers()).thenReturn(userData);
		
		Set<User> users =  userService.getAllUsers();		
		
		assertEquals(users.size(), 1);
		verify(userRepository,  times(1)).findAll();
		System.out.println("\nUsers name is " + users.toString());
		
		
	}
	
	
	
	

}
