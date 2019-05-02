package application.converters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import application.commands.UserCommand;
import application.model.User;
import lombok.Synchronized;

@Component
public class UserCommandToUser implements Converter<UserCommand, User>{

	//2019-04-28 19:06:27.0
	
	String pattern = "yyyy-MM-dd";	
	DateFormat df = new SimpleDateFormat(pattern);	
	
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
	        try {
				user.setCreated(df.parse(source.getCreated()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
        return user;
	}

	
}
