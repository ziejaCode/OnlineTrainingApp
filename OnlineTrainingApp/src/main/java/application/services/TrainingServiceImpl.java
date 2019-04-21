package application.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import application.model.Training;
import application.repositories.TrainingRepository;

@Service
public class TrainingServiceImpl implements TrainingService{
	
	private final TrainingRepository trainingRepository;

	public TrainingServiceImpl(TrainingRepository trainingRepository) {
		this.trainingRepository = trainingRepository;
	}

	public Set<Training> getAllTrainings() {
		Set<Training> trainingSet = new HashSet<>();
		trainingRepository.findAll().iterator().forEachRemaining(trainingSet::add);
	    return trainingSet;
	}
	public String saveTraining(Training training) {		
		trainingRepository.save(training);		
		return "Training saved";
	}

	@Override
	public Optional<Training> getTrainingById(int trainId) {
		
		
		
		return trainingRepository.findById(trainId);
	}

}
