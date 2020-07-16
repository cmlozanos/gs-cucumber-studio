package cmls.spring.cucumberstudio.service;

import cmls.spring.cucumberstudio.dto.User;
import cmls.spring.cucumberstudio.exceptions.NotValidUserException;

public class LoginService {

	private boolean userLogged = false;
	
	
	public User validate(String email) throws NotValidUserException{
		if (!email.isEmpty() && email.contains("@email.com")) {
			userLogged = true;
			return new User(email, email.substring(0, email.indexOf("@")));
		}
		userLogged = false;
		throw new NotValidUserException();
	}

	public boolean isUserLogged() {
		return userLogged;
	}

	public void logout() {
		this.userLogged = false;
	}

}
