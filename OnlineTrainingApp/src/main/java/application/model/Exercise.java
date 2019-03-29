package application.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="exercise")
public class Exercise {
	
	@Id
    @GeneratedValue
	@Column(name="exercise_id")
	private int exercise_id;
	
	@Column(name="exercise_no")
	private int exerciseNo;
	
	@Column(name="exercise_name")
	private String exerciseName;
	
//	@JsonIgnore
//	@ElementCollection
//	@CollectionTable(name="exerciseSet", joinColumns=@JoinColumn(name="exercise_id"))
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="exercise_id", nullable=false)
	private List<ExerciseSet>sets = new ArrayList<ExerciseSet>();

	public Exercise() {
	}
	
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

	@Override
	public String toString() {
		return "\n                                    Exercise [exerciseID=" + exercise_id + ", exerciseNo=" + exerciseNo + ", exerciseName=" + exerciseName
				+ "\n                                             sets=" + sets + "]";
	}

	
	
	
	
	
}
