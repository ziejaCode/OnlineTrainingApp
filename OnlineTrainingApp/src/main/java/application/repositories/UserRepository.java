package application.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import application.commands.UserCommand;
import application.model.User;


public interface UserRepository extends CrudRepository<User, Integer> {
	
	
	
	Optional<User> findByUserName(String userName);

	void deleteByUserName(String userName);
	
}