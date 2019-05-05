package application.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import application.commands.ExerciseCommand;
import application.commands.ExercisesNamesCommand;
import application.model.Exercise;
import application.model.ExercisesNames;
import lombok.Synchronized;

public class ExerciseToExerciseCommand implements Converter<Exercise, ExerciseCommand>{
	
	
	@Synchronized
    @Nullable
	public ExerciseCommand convert(Exercise source) {
		if (source == null) {
            return null;
        }

        final ExerciseCommand exerciseCommand = new ExerciseCommand();
        exerciseCommand.setExercise_id(source.getExercise_id());        
        exerciseCommand.setExerciseNo(source.getExerciseNo());
        exerciseCommand.setExerciseName(source.getExerciseName());
        exerciseCommand.setSets(source.getSets());
       
	    return exerciseCommand;
	}

	
	
	
	
	
	
	
	
	
	
}
