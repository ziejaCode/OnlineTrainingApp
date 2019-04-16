package application.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserUnitTest {

		
	User user;
	Date date; 
	
	@Mock
	Training training;
	
	@Mock
	ExercisesNames exeNames;
	
	List<Training> trainings;
	List<ExercisesNames>exercises;
	
	
	@Before
	public void setUp() {		
		
		date = new Date();
		user = new User();
		user.setUser_id(2);
		user.setUserName("Ciaran");
		user.setUser_email("ciaaran@dsjfkas.com");
		user.setPassword("dkfasf");
		user.setAuthority("USER");
		user.setCreated(date);
		
		MockitoAnnotations.initMocks(Training.class);
		
		trainings = new ArrayList<Training>(); 
		trainings.add(training);		
		user.setTrainings(trainings);
		
		MockitoAnnotations.initMocks(Training.class);
		
		exercises = new ArrayList<ExercisesNames>();
		exercises.add(exeNames);
		user.setExercises(exercises);;
	}
	
	@Test
	public void getUserIdTest() {		
		assertEquals(new Integer(2), user.getUser_id());
		assertNotNull(user.getUser_id());
	}	
	
	@Test
	public void getUserNameTest() {		
		assertEquals("Ciaran", user.getUserName());
		assertNotNull(user.getUserName());
	}	
	
	@Test
	public void getEmailTest() {		
		assertEquals("ciaaran@dsjfkas.com", user.getUser_email());
		assertNotNull(user.getUser_email());
	}
	
	@Test
	public void getPassTest() {		
		assertEquals("dkfasf", user.getPassword());
		assertNotNull(user.getPassword());
	}
	
	@Test
	public void getCreatedTest() {		
		assertEquals(date, user.getCreated());
		assertNotNull(user.getCreated());
	}
	
	@Test
	public void getAuthorityTest() {		
		assertEquals("USER", user.getAuthority());
		assertNotNull(user.getAuthority());
	}
	
	@Test
	public void getTrainingListTest() {
		assertNotNull(user.getTrainings());
		assertEquals(trainings.size(), 1);
		assertNotNull(user.getTrainings());
	}
	
	@Test
	public void getExercisesListTest() {
		assertNotNull(user.getExercises());
		assertEquals(exercises.size(), 1);
		assertNotNull(user.getExercises());
	}
	
	@After
	public void tearDownAfterClass() throws Exception { 		
		user = null;
		date = null;
	}

}
