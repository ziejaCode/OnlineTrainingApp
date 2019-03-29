package application.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;




@Entity
@Table(name="exercisesNames")
public class ExercisesNames {
	
	@Id
    @GeneratedValue
	@Column(name="exercisename_id")
	private int exerciseNameID;
	
	@Column(name="exercise_name")
	private String exercise_name;
	
	@Column(name="body_part")
	private String body_part;	
	
	
	@Column(name="user_id")
	@Transient
	private int user_id;
	

	public ExercisesNames() {}
	

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


	@Override
	public String toString() {
		return "\n                     ExercisesNames [exercise_name=" + exercise_name + ", body_part=" + body_part
				+ ", user_id=" + user_id + "]";
	}

	
	 
}
