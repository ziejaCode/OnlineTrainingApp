package application.commands;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import application.model.ExerciseSet;

@NoArgsConstructor
public class ExerciseCommand {
	
	private int exercise_id;
	private int exerciseNo;
	private String exerciseName;
	private List<ExerciseSet>sets = new ArrayList<ExerciseSet>();
	
	
	public int getExercise_id() {
		return exercise_id;
	}
	public void setExercise_id(int exercise_id) {
		this.exercise_id = exercise_id;
	}
	public int getExerciseNo() {
		return exerciseNo;
	}
	public void setExerciseNo(int exerciseNo) {
		this.exerciseNo = exerciseNo;
	}
	public String getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	public List<ExerciseSet> getSets() {
		return sets;
	}
	public void setSets(List<ExerciseSet> sets) {
		this.sets = sets;
	}
	
	
	

}
