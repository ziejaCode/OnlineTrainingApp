package application.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import application.commands.TrainingCommand;
import application.model.Training;
import lombok.Synchronized;

public class TrainingToTrainingCommand implements Converter<Training, TrainingCommand>{
	
	@Synchronized
    @Nullable
	public TrainingCommand convert(Training source) {
		if (source == null) {
            return null;
        }

        final TrainingCommand trainingCommand = new TrainingCommand();
        trainingCommand.setId_train(source.getId_train());        
        trainingCommand.setTraining_name(source.getTraining_name());
        trainingCommand.setWeek_day(source.getWeek_day());
        trainingCommand.setExercises(source.getExercises());
       
	    return trainingCommand;
	}
	

}
