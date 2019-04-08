package application.model;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class UserUnitTest {

	User user;
	Date date;
	
	@Before
	public void setUp() {
		
		date = new Date();
		user = new User();
		user.setUserName("Ciaran");
		user.setUser_email("ciaaran@dsjfkas.com");
		user.setPassword("dkfasf");
		user.setAuthority("USER");
		user.setCreated(date);
	}	
	
	@Test
	public void getUserNameTest() {		
		assertEquals("Ciaran", user.getUserName());
	}	
	
	@Test
	public void getCreatedTest() {		
		assertEquals(date, user.getCreated());
	}

}
