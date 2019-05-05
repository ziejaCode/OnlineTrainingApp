package application.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import application.commands.ExerciseCommand;
import application.model.Exercise;
import lombok.Synchronized;

public class ExerciseCommandToExercise implements Converter<ExerciseCommand, Exercise>{
	
	
	@Synchronized
    @Nullable
	public Exercise convert(ExerciseCommand source) {
		if (source == null) {
            return null;
        }

        final Exercise exercise = new Exercise();
        exercise.setExercise_id(source.getExercise_id());        
        exercise.setExerciseNo(source.getExerciseNo());
        exercise.setExerciseName(source.getExerciseName());
        exercise.setSets(source.getSets());
       
	    return exercise;
	}

}
