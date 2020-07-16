package cmls.spring.cucumberstudio.hiptest;

import junit.framework.TestCase;

public class LogoutUserTest extends TestCase {

    public MyActionwords actionwords = new MyActionwords();

    public void testLogoutUser() {
        // Given Login Service
        actionwords.loginService();
        // When Login Service logout
        actionwords.loginServiceLogout();
        // And assert user not logged
        actionwords.assertUserNotLogged();
    }
}