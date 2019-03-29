package application.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="exercise_set")
public class ExerciseSet {
	
	@Id
    @GeneratedValue
	@Column(name="set_id")
	private int set_id;
	
	@Column(name="set_no")
	private int set_no;
	
	@Column(name="reps")
	private int reps;
	
	@Column(name="weight")
	private double weight;

	public ExerciseSet() {
	}
	
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

	@Override
	public String toString() {
		return "\n                                                   ExerciseSet [set_no=" + set_no + ", reps=" + reps + ", weight=" + weight + ", exercise_id="
//				+ exercise_id 
				+ "]";
	}

}
