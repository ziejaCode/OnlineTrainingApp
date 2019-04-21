package application.converters;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import application.commands.UserCommand;

public class UserCommandToUserTest {

	
	private Integer user_id = 4;
    private String userName = "Holek";    
    private String user_email = "holek@gsadfsj.com";
	private String password = "holek45445";	
	private String authority = "USER";
	private Date created = new Date(); 
	
	UserCommandToUser userCommandToUser;
	
	@Before
	public void setUp() throws Exception {
		userCommandToUser = new UserCommandToUser();
		
	}

	@After
	public void tearDown() throws Exception {
		userCommandToUser = null;
	}

	@Test
    public void testNullObject() throws Exception {
        assertNull(userCommandToUser.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(userCommandToUser.convert(new UserCommand()));
    }

	
	@Test
	public void testConvert() throws Exception {
		
		UserCommand userCommand = new UserCommand();
		userCommand.setUser_id(user_id);         
		userCommand.setUserName(userName);
		userCommand.setUser_email(user_email);
		userCommand.setPassword(password);
		userCommand.setAuthority(authority);
		userCommand.setCreated(created);
		
		
	}

}
