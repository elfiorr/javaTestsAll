package packageWithAllTests.ui.tpExamplesTests.tpWithoutCucumber.loginTests;

import java.io.FileNotFoundException;

public class LoginWithCorrectLoginAnBlankPasswordTest extends LoginTests {

    private static final String LOGIN = "test_tmn";
    private static final String PASSWORD = "";
    private static final String URL = "/login";
    private static final boolean MENU = false;

    public LoginWithCorrectLoginAnBlankPasswordTest() throws FileNotFoundException {
        super(
                LOGIN,
                PASSWORD,
                URL,
                MENU
        );
    }
}
