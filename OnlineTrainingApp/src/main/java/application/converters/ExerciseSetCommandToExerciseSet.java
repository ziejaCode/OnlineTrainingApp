package application.converters;

import org.springframework.core.convert.converter.Converter;

import application.commands.ExerciseSetCommand;
import application.model.ExerciseSet;

public class ExerciseSetCommandToExerciseSet implements Converter<ExerciseSetCommand, ExerciseSet>{

	@Override
	public ExerciseSet convert(ExerciseSetCommand source) {		
		
		final ExerciseSet exerciseSet = new ExerciseSet();
		exerciseSet.setSet_id(source.getSet_id());        
		exerciseSet.setSet_no(source.getSet_no());
		exerciseSet.setReps(source.getReps());
		exerciseSet.setWeight(source.getWeight());
       
	    return exerciseSet;
		
	}
}
