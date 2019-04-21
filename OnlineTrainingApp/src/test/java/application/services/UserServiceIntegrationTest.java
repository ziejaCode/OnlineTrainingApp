package application.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import application.model.User;
import application.repositories.UserRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UserServiceIntegrationTest {
	
	UserService userService;	
	
	@Autowired
	UserRepository userRepository;
	
	@Before
	public void createUserService() throws Exception {
		userService = new UserServiceImpl(userRepository);
	}

	@Test
	public void testUserServiceImpl() {
		assertNotNull(userService);
	}

	@Test
	public void testGetUserByUserName() {
		
		User user = userService.getUserByUserName("borek");		
		
		assertEquals("gienia", user.getPassword());
		assertEquals(new Integer(7), user.getUser_id());
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

	@Test
	public void testGetAllUsers() {	
		
		Set<User> users =  userService.getAllUsers();
		assertEquals(users.size(), 5);
		// test to delete
		System.out.println("\nUsers name is " + users.toString());
	}

//	@Test
//	public void testDeleteAllUsers() {
//		fail("Not yet implemented");
//	}

	@After
	public void tearDown() throws Exception {
		userService = null;
		userRepository = null;
	}
}
