package application.commands;

import java.util.ArrayList;
import java.util.List;

import application.model.Exercise;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TrainingComannd {
	
    private Integer id_train;
	private String training_name;
	private String week_day;	
	private List<Exercise> exercises = new ArrayList<Exercise>();
	public Integer getId_train() {
		return id_train;
	}
	public void setId_train(Integer id_train) {
		this.id_train = id_train;
	}
	public String getTraining_name() {
		return training_name;
	}
	public void setTraining_name(String training_name) {
		this.training_name = training_name;
	}
	public String getWeek_day() {
		return week_day;
	}
	public void setWeek_day(String week_day) {
		this.week_day = week_day;
	}
	public List<Exercise> getExercises() {
		return exercises;
	}
	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
	
	

}
