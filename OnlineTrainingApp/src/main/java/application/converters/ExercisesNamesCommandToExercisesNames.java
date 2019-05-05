package application.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import application.commands.ExercisesNamesCommand;
import application.model.ExercisesNames;
import lombok.Synchronized;

public class ExercisesNamesCommandToExercisesNames implements Converter<ExercisesNamesCommand, ExercisesNames>{
	
	@Synchronized
    @Nullable
	public ExercisesNames convert(ExercisesNamesCommand source) {
		if (source == null) {
            return null;
        }

        final ExercisesNames exercisesNames = new ExercisesNames();
        exercisesNames.setExerciseNameID(source.getExerciseNameID());        
        exercisesNames.setExercise_name(source.getExercise_name());
        exercisesNames.setBody_part(source.getBody_part());
        exercisesNames.setUser_id(source.getUser_id());
       
	    return exercisesNames;
	}
}
