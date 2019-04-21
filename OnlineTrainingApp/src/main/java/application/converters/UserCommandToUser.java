package application.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import application.commands.UserCommand;
import application.model.User;
import lombok.Synchronized;

@Component
public class UserCommandToUser implements Converter<UserCommand, User>{

	@Synchronized
    @Nullable
	@Override
	public User convert(UserCommand source) {
		if (source == null) {
            return null;
        }

        final User user = new User();
	        user.setUser_id(source.getUser_id());         
	        user.setUserName(source.getUserName());
	        user.setUser_email(source.getUser_email());
	        user.setPassword(source.getPassword());
	        user.setAuthority(source.getAuthority());
	        user.setCreated(source.getCreated());
        return user;
	}

}
