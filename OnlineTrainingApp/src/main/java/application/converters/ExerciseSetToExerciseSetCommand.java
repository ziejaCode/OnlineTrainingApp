package application.converters;

import org.springframework.core.convert.converter.Converter;

import application.commands.ExerciseSetCommand;
import application.model.ExerciseSet;

public class ExerciseSetToExerciseSetCommand implements Converter<ExerciseSet, ExerciseSetCommand>{

	@Override
	public ExerciseSetCommand convert(ExerciseSet source) {		
		
		final ExerciseSetCommand exerciseSetCommand = new ExerciseSetCommand();
		exerciseSetCommand.setSet_id(source.getSet_id());        
		exerciseSetCommand.setSet_no(source.getSet_no());
		exerciseSetCommand.setReps(source.getReps());
		exerciseSetCommand.setWeight(source.getWeight());
       
	    return exerciseSetCommand;
		
	}

}
