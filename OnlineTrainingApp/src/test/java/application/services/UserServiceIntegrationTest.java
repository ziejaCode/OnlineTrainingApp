package application.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
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
//@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UserServiceIntegrationTest {
	
	@Autowired
	UserService userService;	
	@Autowired
	UserRepository userRepository;	
	@Autowired
	UserCommandToUser userCommandToUser;
	@Autowired
	UserToUserCommand userToUserCommand;

	User user;
	
	@Before
	public void setUp(){
		
		user = new User();
		user.setUser_id(23);         
        user.setUserName("Kali");
        user.setUser_email("kali@fsdfj");
        user.setPassword("jfksadfas");
        user.setAuthority("USER");
        user.setCreated(new Date());
	}
	
	
	@Transactional
	@Test
	public void testSaveOrUpdateUser() {
		
		Iterable<User>users = userRepository.findAll();
		User testUser = users.iterator().next();
		UserCommand userCommandTest = userToUserCommand.convert(testUser);
		
		userCommandTest.setUserName("Gniewkol");
		UserCommand userCommandSave = userService.saveOrUpdateUser(userCommandTest);
		
		assertEquals("Gniewkol", userCommandSave.getUserName());		
	}
	
	@Transactional
	@Test
	public void testSaveUser() {
		
		assertEquals("User Saved", userService.saveUser(user));		
	}
	
	
	@Test
	public void testGetUserByUserName() {
		
		User user = userService.getUserByUserName("Baton");		
		
		assertEquals("fkasfas;jf", user.getPassword());
		assertEquals(new Integer(18), user.getUser_id());
		assertNotNull(user);		
	}

	
	@Test
	public void testDeleteUser() {	
		String name = "Baton";
		userService.deleteByUserName(name);
	}

	@Test
	public void testGetAllUsers() {	
		
		Set<User> users =  userService.getAllUsers();
		
		assertEquals(users.size(), 7);
		
		// test to delete
		//System.out.println("\nUsers name is " + users.toString());
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
