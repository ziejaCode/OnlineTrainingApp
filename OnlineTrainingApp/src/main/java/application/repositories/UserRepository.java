package application.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import application.model.User;


public interface UserRepository extends CrudRepository<User, Integer> {
	
		
	//Optional<User> findByPassword(String password);
	
	Optional<User> findByUserName(String userName);
	
//	Optional<User> findByDescription(String description);

}