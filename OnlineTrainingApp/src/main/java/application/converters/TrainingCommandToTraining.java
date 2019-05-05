package application.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import application.commands.TrainingCommand;
import application.model.Training;
import lombok.Synchronized;

public class TrainingCommandToTraining implements Converter<TrainingCommand, Training>{
	
	@Synchronized
    @Nullable
	public Training convert(TrainingCommand source) {
		if (source == null) {
            return null;
        }

        final Training training = new Training();
        training.setId_train(source.getId_train());        
        training.setTraining_name(source.getTraining_name());
        training.setWeek_day(source.getWeek_day());
        training.setExercises(source.getExercises());
       
	    return training;
	}

	
	
}
