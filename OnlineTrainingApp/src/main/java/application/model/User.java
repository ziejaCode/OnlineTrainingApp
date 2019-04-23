package application.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User {
	
	@Id
    @GeneratedValue
    @Column(name="user_id")
    private Integer user_id;

    @Column(name="user_name")
    //private String user_name;
    private String userName;
    
    @Column(name="user_email")
    private String user_email;

    @Column(name="password")
	private String password;
	
	@Column(name="authority")
	private String authority;

	@Column(name="created")
	private Date created;
	
	//@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", nullable=false)
	private List<ExercisesNames>exercises = new ArrayList<ExercisesNames>();
	
	@JsonIgnore	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", nullable=false)
	private List<Training>trainings = new ArrayList<Training>();
	
	
	
	public User() {
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

//	public String getUser_name() {
//		return user_name;
//	}
//
//	public void setUser_name(String user_name) {
//		this.user_name = user_name;
//	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//////////////////////////////////////////////////
	
	public String getUser_email() {
		return user_email;
	}

	

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}


	public List<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}
	
	
	
	public List<ExercisesNames> getExercises() {
		return exercises;
	}

	public void setExercises(List<ExercisesNames> exercises) {
		this.exercises = exercises;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + userName + ", user_email=" + user_email + ", password="
				+ password + ", authority=" + authority + ", created=" + created + "\n         exercises : " + exercises + "\n         trainings : " + trainings + "\n      ]";
	}

	

	
	

}
