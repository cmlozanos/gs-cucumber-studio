package cmls.spring.cucumberstudio.hiptest;

import junit.framework.TestCase;

public class LoginWithUserEmailTest extends TestCase {

    public Actionwords actionwords = new Actionwords();

    public void testAdministratorUserUida7db6217db6b445baa38490b02bfb241() {
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

    public void testGuestUserUid4dc65cc510944c13932adcf67e2850b3() {
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

    public void testInvalidUserUid24d73af1e0b947ecb97ca2492fc3d231() {
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