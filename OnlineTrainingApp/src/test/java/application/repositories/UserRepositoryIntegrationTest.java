package application.repositories;
import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import application.Application;
import application.model.User;
import application.repositories.UserRepository;
import org.springframework.boot.test.context.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UserRepositoryIntegrationTest {

	@Autowired
	UserRepository userRepository;
	
	@Before
	public void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testGetUserByUserName() {
		
//			Optional<User> user = userRepository.findByUserName("borek");
//			assertEquals("gienia", user.get().getPassword());
			
			User user = userRepository.findByUserName("borek");			
			assertEquals("gienia", user.getPassword());
			assertEquals(new Integer(7), user.getUser_id());
			assertNotNull(user);
			
			System.out.println();
			System.out.println();
//			System.out.println("I jest " + user.get().getUserName());
			System.out.println("I jest " + user.getUserName());
			System.out.println();
			System.out.println();
			
		
	}

}
