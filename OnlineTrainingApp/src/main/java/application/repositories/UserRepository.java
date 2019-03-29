package application.repositories;

import org.springframework.data.repository.CrudRepository;

import application.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}