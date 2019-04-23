package application.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import application.commands.UserCommand;
import application.model.User;

@Service
public interface UserService {
	
	public UserCommand saveOrUpdateUser(UserCommand user);

	public String saveUser(User user);
	
	public User getUserByUserName(String name);
	
	public User getUserByUserId(int i);
	
	public String deleteByUserName(String userName);
	
	
	
	public Set<User> getAllUsers();
	
	public String deleteAllUsers();

	
	
}
