package cmls.spring.cucumberstudio.hiptest.customization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cmls.spring.cucumberstudio.exceptions.NotValidUserException;
import cmls.spring.cucumberstudio.hiptest.Actionwords;
import cmls.spring.cucumberstudio.service.LoginService;

public class MyActionwords extends Actionwords {

	private String email;
	private LoginService loginService;

	@Override
	public void theEmail(String email) {
		this.email = email;
	}

	@Override
	public void theLoginServiceValidateEmail() {
		try {
			loginService.validate(email);
		} catch (NotValidUserException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void assertUserLogged() {
		assertTrue(loginService.isUserLogged());
	}

	@Override
	public void loginService() {
		loginService = new LoginService();
	}

	@Override
	public void assertUserReturned() {
		try {
			assertEquals(email, loginService.validate(email).getEmail());
			assertEquals(email.substring(0, email.indexOf("@")), loginService.validate(email).getName());
		} catch (NotValidUserException e) {
			throw new RuntimeException("invalid way");
		}
	}

	@Override
	public void assertUserNotLogged() {
		assertFalse(loginService.isUserLogged());
	}

	@Override
	public void assertThrowNotValidUserException() {
		assertThrows(NotValidUserException.class, () -> loginService.validate(email));
	}
	
	@Override
	public void loginServiceLogout() {
		loginService.logout();
	}
}
