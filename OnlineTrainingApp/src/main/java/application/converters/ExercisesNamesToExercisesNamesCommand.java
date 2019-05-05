package application.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import application.commands.ExercisesNamesCommand;
import application.model.ExercisesNames;
import lombok.Synchronized;

public class ExercisesNamesToExercisesNamesCommand implements Converter<ExercisesNames, ExercisesNamesCommand>{
	
	@Synchronized
    @Nullable
	public ExercisesNamesCommand convert(ExercisesNames source) {
		if (source == null) {
            return null;
        }

        final ExercisesNamesCommand exercisesNamesCommand = new ExercisesNamesCommand();
        exercisesNamesCommand.setExerciseNameID(source.getExerciseNameID());        
        exercisesNamesCommand.setExercise_name(source.getExercise_name());
        exercisesNamesCommand.setBody_part(source.getBody_part());
        exercisesNamesCommand.setUser_id(source.getUser_id());
       
	    return exercisesNamesCommand;
	}

}
