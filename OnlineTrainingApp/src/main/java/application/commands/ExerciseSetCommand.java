package application.commands;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ExerciseSetCommand {
	
	
	private int set_id;	
	private int set_no;	
	private int reps;	
	private double weight;
	public int getSet_id() {
		return set_id;
	}
	public void setSet_id(int set_id) {
		this.set_id = set_id;
	}
	public int getSet_no() {
		return set_no;
	}
	public void setSet_no(int set_no) {
		this.set_no = set_no;
	}
	public int getReps() {
		return reps;
	}
	public void setReps(int reps) {
		this.reps = reps;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	

}
