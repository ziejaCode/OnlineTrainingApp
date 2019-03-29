package application.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import application.model.Training;

@Service
public interface TrainingService {

	public Set<Training> getAllTrainings();

	public String saveTraining(Training training);

	public Optional<Training>  getTrainingById(int trainId);
}
