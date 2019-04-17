package application.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import application.model.User;
import application.repositories.UserRepository;

public class UserServiceImplTest {

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
	public void testUserServiceImpl() {
		assertNotNull(userService);
	}

	@Test
	public void testGetUserById() {
		
		
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
		
		User user = new User();
		HashSet<User> userData = new HashSet();
		userData.add(user);
		
		when(userService.getAllUsers()).thenReturn(userData);
		
		Set<User> users =  userService.getAllUsers();		
		
		assertEquals(users.size(), 1);
		verify(userRepository,  times(1)).findAll();
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
