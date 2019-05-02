package application.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import application.commands.UserCommand;
import application.model.User;

@Service
public interface UserService {
	
	public UserCommand updateUser(UserCommand user);
//	public User updateUser(User user);
	
	public String saveUser(User user);
	
	public User getUserByUserName(String name);
	
	public User getUserByUserId(int i);
	
	public String deleteByUserName(String userName);
	
	public String deleteByUserId(Integer id);
	
	public Set<User> getAllUsers();
	
	public String deleteAllUsers();

	
	
}
