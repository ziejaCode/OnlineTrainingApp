package application.commands;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ExercisesNamesCommand {
	
	private int exerciseNameID;
	private String exercise_name;
	private String body_part;	
	private int user_id;
	public int getExerciseNameID() {
		return exerciseNameID;
	}
	public void setExerciseNameID(int exerciseNameID) {
		this.exerciseNameID = exerciseNameID;
	}
	public String getExercise_name() {
		return exercise_name;
	}
	public void setExercise_name(String exercise_name) {
		this.exercise_name = exercise_name;
	}
	public String getBody_part() {
		return body_part;
	}
	public void setBody_part(String body_part) {
		this.body_part = body_part;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	
	
}
