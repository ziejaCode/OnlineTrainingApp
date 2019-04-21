package application.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import application.commands.UserCommand;
import application.converters.UserCommandToUser;
import application.converters.UserToUserCommand;
import application.model.User;
import application.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	private final UserCommandToUser userCommandToUser;
	private final UserToUserCommand userToUserCommand;
	
	
	
	
	public UserServiceImpl(UserRepository userRepository, UserCommandToUser userCommandToUser, UserToUserCommand userToUserCommand) {
		this.userRepository = userRepository;
		this.userCommandToUser = userCommandToUser;
		this.userToUserCommand = userToUserCommand;
	}

//	@Override
//	public Optional<User> getUserByUserName(String name) {
//		Optional<User> user = userRepository.findByUserName(name);
//		return user;
//	}

	
	@Override
	public User getUserByUserName(String name) {
		User user = userRepository.findByUserName(name);
		return user;
	}
	
	
//	@Override
//	public String saveUser(User user) {		
//		userRepository.save(user);		
//		return "User saved";
//	}

//	@Override
//	public String updateUser(User user) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public String deleteUserByName(String userName) {
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

	@Override
	public void saveOrUpdateUser(User user) {		
		userRepository.save(user);
	}

	@Override
	@Transactional
	public UserCommand saveUserCommand(UserCommand userCommand) {
		
		User detachedUser = userCommandToUser.convert(userCommand);

		User savedUser = userRepository.save(detachedUser);
        //log.debug("Saved UserName:" + savedUser.getUserName());
        return userToUserCommand.convert(savedUser);		
	}




	
	


}
