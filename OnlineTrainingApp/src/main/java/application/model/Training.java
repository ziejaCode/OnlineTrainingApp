package application.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="training")
public class Training {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="training_id")
    private Integer id_train;
	
	@Column(name="training_name")
	private String training_name;
	
	
	@Column(name="week_day")
	private String week_day;	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="training_id", nullable=false)
	private List<Exercise> exercises = new ArrayList<Exercise>();
	
//	@ManyToOne	
//	@JoinColumn(name="id_user")
//	private User user;	
	
	
//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "training_plan",
//            joinColumns = @JoinColumn(name = "id_train"),
//            inverseJoinColumns = @JoinColumn(name = "exe_id")
//    )	
//	private Set<Exercise> exercises;
////	= new HashSet<Exercise>();
	
	
	
	public Training() {
	}
	
	public Integer getId_train() {
		return id_train;
	}
	public void setId_train(Integer id_train) {
		this.id_train = id_train;
	}
	
	public String getTraining_name() {
		return training_name;
	}
	public void setTraining_name(String trainingName) {
		this.training_name = trainingName;
	}


	public String getWeek_day() {
		return week_day;
	}
	public void setWeek_day(String weekDay) {
		this.week_day = weekDay;
	}

		
	public List<Exercise> getExercises() {
		return exercises;
	}
	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

	@Override
	public String toString() {
		return "\n                     Training [id_train=" + id_train + ", training_name=" + training_name + ", week_day=" + week_day + "\n                              exercises :" + exercises  + "]";
	}


	

}	
	
	
	