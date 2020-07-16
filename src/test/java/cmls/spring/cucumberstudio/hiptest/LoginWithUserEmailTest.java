package cmls.spring.cucumberstudio.hiptest;

import cmls.spring.cucumberstudio.hiptest.customization.MyActionwords;
import junit.framework.TestCase;

public class LoginWithUserEmailTest extends TestCase {

    public MyActionwords actionwords = new MyActionwords();

    public void testAdministratorUser() {
        // Given the email "admin@email.com"
        actionwords.theEmail("admin@email.com");
        // And Login Service
        actionwords.loginService();
        // When the Login Service validate email
        actionwords.theLoginServiceValidateEmail();
        // Then assert user logged
        actionwords.assertUserLogged();
        // And assert user returned
        actionwords.assertUserReturned();
    }

    public void testGuestUser() {
        // Given the email "guest@email.com"
        actionwords.theEmail("guest@email.com");
        // And Login Service
        actionwords.loginService();
        // When the Login Service validate email
        actionwords.theLoginServiceValidateEmail();
        // Then assert user logged
        actionwords.assertUserLogged();
        // And assert user returned
        actionwords.assertUserReturned();
    }

    public void testInvalidUser() {
        // Given the email "guest@otheremail.com"
        actionwords.theEmail("guest@otheremail.com");
        // And Login Service
        actionwords.loginService();
        // When the Login Service validate email
        actionwords.theLoginServiceValidateEmail();
        // Then assert user not logged
        actionwords.assertUserNotLogged();
        // And assert throw Not Valid User exception
        actionwords.assertThrowNotValidUserException();
    }
}