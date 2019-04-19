package application.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import application.model.User;

@Service
public interface UserService {	
	

	public String saveUser(User user);

	public Optional<User> getUserByUserName(String name);

	public String updateUser(User user);
	
	public String deleteUser(String userName);
	
	
	public Set<User> getAllUsers();
	
	public String deleteAllUsers();
	
}
