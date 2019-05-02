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

	@Override
	@Transactional
	public UserCommand updateUser(UserCommand userCommand) {		
		User detachedUser = userCommandToUser.convert(userCommand);
		User savedUser = userRepository.save(detachedUser);
        //log.debug("Saved UserName:" + savedUser.getUserName());
       
		
		
		
		
		
		
		
		
		return userToUserCommand.convert(savedUser);		
	}

//	@Override
//	@Transactional
//	public User updateUser(User user) {	
//		User savedUser = null;
//		if(!(user == null)) {
//			savedUser = userRepository.save(user);
//		}
//        return savedUser;		
//	}
	
	
	@Override
	@Transactional
	public String saveUser(User user) {
		userRepository.save(user);
		return "User Saved";
	}
	
	@Override
	public User getUserByUserName(String name) {	
		Optional<User> returned = userRepository.findByUserName(name);
		return returned.get();
	}
	
	@Override
	public User getUserByUserId(int id) {		
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
            throw new RuntimeException("User Not Found!");
        }
        return userOptional.get();
	}

	@Override
	public String deleteByUserName(String userName) {		
		userRepository.deleteByUserName(userName);
		return "User deleted";
	}

	@Override
	public String deleteByUserId(Integer id) {
		userRepository.deleteById(id);
		return "Usere no. " + id + " was deleted";
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
		userRepository.deleteAll();
		return null;
	}

	

	

    

	




	
	


}
