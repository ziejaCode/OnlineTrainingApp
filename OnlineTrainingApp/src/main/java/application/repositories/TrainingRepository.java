package application.repositories;

import org.springframework.data.repository.CrudRepository;

import application.model.Training;

public interface TrainingRepository extends CrudRepository<Training, Integer>{

}
