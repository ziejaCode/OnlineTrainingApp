package application.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercisesNamesTest {

	ExercisesNames exercise;
	
	@Before
	public void setUp() throws Exception {
		 
		exercise = new ExercisesNames();
		exercise.setExerciseNameID(34);
		exercise.setExercise_name("Pull row");
		exercise.setBody_part("KLATA");
		exercise.setUser_id(1);
	}
		
	@Test
	public void testGetExerciseNameID() {
		exercise.getExerciseNameID();
	}
	

	@Test
	public void testGetExercise_name() {
		exercise.getExercise_name();
	}

	@Test
	public void testGetBody_part() {
		exercise.getBody_part();
	}	

	@Test
	public void testGetUser_id() {
		exercise.getUser_id();
	}
	
	@Test
	public void testToString() {
		System.out.println(exercise.toString());
	}
	
	@After
	public void tearDown() throws Exception {
		exercise = null;
	}

}
