package application.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import application.model.User;

@Service
public interface UserService {
	
	public Set<User> getAllUsers();

	public String saveUser(User user);

	public Optional<User> getUserById(int i);

	
}
