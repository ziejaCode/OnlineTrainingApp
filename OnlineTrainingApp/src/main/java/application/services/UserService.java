package application.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import application.commands.UserCommand;
import application.model.User;

@Service
public interface UserService {	
	

	
	public void saveOrUpdateUser(User user);

	public UserCommand saveUserCommand(UserCommand userCommand);
	
	
	//public String saveUser(User user);
	
	public User getUserByUserName(String name);

	//public String updateUser(User user);
	
	public String deleteUserByName(String userName);
	
	
	
	
	public Set<User> getAllUsers();
	
	public String deleteAllUsers();

	
	
}
