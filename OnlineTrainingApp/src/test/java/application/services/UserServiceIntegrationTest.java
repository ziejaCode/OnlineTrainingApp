package application.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import application.commands.UserCommand;
import application.converters.UserCommandToUser;
import application.converters.UserToUserCommand;
import application.model.User;
import application.repositories.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceIntegrationTest {
	
	@Autowired
	UserService userService;	
	@Autowired
	UserRepository userRepository;	
	@Autowired
	UserCommandToUser userCommandToUser;
	@Autowired
	UserToUserCommand userToUserCommand;

	@Transactional
	@Test
	public void testSaveUserName() {
		
		Iterable<User>users = userRepository.findAll();
		User testUser = users.iterator().next();
		UserCommand userCommandTest = userToUserCommand.convert(testUser);
		
		userCommandTest.setUserName("Gniewkol");
		UserCommand userCommandSave = userService.saveUserCommand(userCommandTest);
		
		assertEquals("Gniewkol", userCommandSave.getUserName());
		
	}
	
	@Test
	public void testGetUserByUserName() {
		
		User user = userService.getUserByUserName("Gniewkol");		
		
		assertEquals("", user.getPassword());
		assertEquals(new Integer(1), user.getUser_id());
		assertNotNull(user);
		
		
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

//	@Test
//	public void testGetAllUsers() {	
//		
//		Set<User> users =  userService.getAllUsers();
//		assertEquals(users.size(), 5);
//		// test to delete
//		System.out.println("\nUsers name is " + users.toString());
//	}

//	@Test
//	public void testDeleteAllUsers() {
//		fail("Not yet implemented");
//	}

//	@After
//	public void tearDown() throws Exception {
//		userService = null;
//		userRepository = null;
//	}
}
