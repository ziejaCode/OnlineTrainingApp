package application.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import application.model.User;
import application.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Optional<User> getUserById(int i) {
		Optional<User> user = userRepository.findById(i);
		return user;
	}
	
	@Override
	public Set<User> getAllUsers() {
		Set<User> userSet = new HashSet<>();
		userRepository.findAll().iterator().forEachRemaining(userSet::add);
	    return userSet;
	}
	@Override
	public String saveUser(User user) {		
		userRepository.save(user);		
		return "User saved";
	}

	


}
