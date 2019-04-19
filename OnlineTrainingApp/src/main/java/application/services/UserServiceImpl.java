package application.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
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
	public Optional<User> getUserByUserName(String name) {
		Optional<User> user = userRepository.findByUserName(name);
		return user;
	}

	
	
	
	
	@Override
	public String saveUser(User user) {		
		userRepository.save(user);		
		return "User saved";
	}

	@Override
	public String updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Set<User> getAllUsers() {
		Set<User> userSet = new HashSet<>();
		userRepository.findAll()
		.iterator().forEachRemaining(userSet::add);
	    return userSet;
	}
	
	@Override
	public String deleteAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}




	
	


}
