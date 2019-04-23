package application.services;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import application.commands.UserCommand;
import application.converters.UserCommandToUser;
import application.converters.UserToUserCommand;
import application.model.User;
import application.repositories.UserRepository;



public class UserServiceUnitTest {

	
	UserServiceImpl userService;	
	@Mock
    UserRepository userRepository;
	@Mock
	UserCommandToUser userCommandToUser;
	@Mock
	UserToUserCommand userToUserCommand;
	
	User user;
	
	@Before
	public void createUserService() throws Exception {
		
		user = new User();
		user.setUser_id(23);         
        user.setUserName("Kali");
        user.setUser_email("kali@fsdfj");
        user.setPassword("jfksadfas");
        user.setAuthority("USER");
        user.setCreated(new Date());		
		
		MockitoAnnotations.initMocks(this);	
		userService = new UserServiceImpl(userRepository, userCommandToUser, userToUserCommand);		
		
		
	}

	@Test
	public void testUserServiceImpl() {
		assertNotNull(userService);
	}

	
	@Test
	public void testSaveOrUpdateUser() {
		
		Optional<User> userOptional = Optional.of(user);
		
		when(userRepository.findByUserName("Kali")).thenReturn(userOptional);
		
		User returned = userService.getUserByUserName("Kali");
		
		assertEquals("Kali", returned.getUserName());
		assertNotNull(returned);
		
		returned.setUserName("Franklin");
		
		when(userRepository.save(returned)).thenReturn(returned);
		
		userService.saveOrUpdateUser(userToUserCommand.convert(returned));
		
		
		userOptional = Optional.of(user);
		
		when(userRepository.findByUserName("Franklin")).thenReturn(userOptional);
		
		returned = userService.getUserByUserName("Franklin");
		
		assertEquals("Franklin", returned.getUserName());
		assertNotNull(returned);		
		
	}
	
	@Test
	public void testSaveUser() {
		
		assertEquals("User Saved", userService.saveUser(user));
		
	}
	
	
	@Test
	public void testGetUserByUserName() {
		
		User user = new User();
		user.setUserName("Miron");		
		
		Optional<User> userOptional = Optional.of(user);
		
		when(userRepository.findByUserName("Miron")).thenReturn(userOptional);
		
		User returned = userService.getUserByUserName("Miron");
		
		assertEquals("Miron", returned.getUserName());
		assertNotNull(returned);
		
		
	}
	
	@Test
	public void testGetUserByUserId() {
		
		User user = new User ();
		user.setUser_id(6);
		
		Optional<User> userOptional = Optional.of(user);		
		
		when(userRepository.findById(6)).thenReturn(userOptional);		
		
		User userReturned = userService.getUserByUserId(6);
				
		assertNotNull("Null user returned", userReturned);
        verify(userRepository, times(1)).findById(6);
        verify(userRepository, never()).findAll();		
				
		assertEquals(new Integer(6), user.getUser_id());
		assertNotNull(user);
	}

	@Test
	public void testDeleteUser() {
		String name = "Baton";
		assertEquals("User deleted", userService.deleteByUserName(name));
	}
	
	
	
	
	
//	@Test
//	public void testSaveUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteUser() {
//		fail("Not yet implemented");
//	}

	//@Test
//	public void testGetAllUsers() {
//		
//		User user = new User();
//		user.setUserName("Gienek");
//		HashSet<User> userData = new HashSet();
//		userData.add(user);
//		
//		when(userService.getAllUsers()).thenReturn(userData);
//		
//		Set<User> users =  userService.getAllUsers();		
//		
//		assertEquals(users.size(), 1);
//		verify(userRepository,  times(1)).findAll();
//		System.out.println("\nUsers name is " + users.toString());
//	}

//	@Test
//	public void testDeleteAllUsers() {
//		fail("Not yet implemented");
//	}

	

	@After
	public void tearDown() throws Exception {
//		userService = null;
		userRepository = null;
	}
}
