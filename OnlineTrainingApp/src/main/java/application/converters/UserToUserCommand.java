package application.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import application.commands.UserCommand;
import application.model.User;
import lombok.Synchronized;

@Component
public class UserToUserCommand implements Converter<User, UserCommand>{

	
	
	
	@Synchronized
    @Nullable
	@Override
	public UserCommand convert(User source) {
		if (source == null) {
            return null;
        }

        final UserCommand userCommand = new UserCommand();
        userCommand.setUser_id(source.getUser_id());         
        userCommand.setUserName(source.getUserName());
        userCommand.setUser_email(source.getUser_email());
        userCommand.setPassword(source.getPassword());
        userCommand.setAuthority(source.getAuthority());
        userCommand.setCreated(source.getCreated());
        
	    return userCommand;
	}

}
