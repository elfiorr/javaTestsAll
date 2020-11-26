package packageWithAllTests.ui.tpExamplesTests.tpWithoutCucumber.loginTests;

import org.junit.jupiter.api.Tag;

import java.io.FileNotFoundException;

@Tag("DO STALEJ")
public class LoginWithBlankLoginAndIncorrectPasswordTest extends LoginTests{

    private static final String LOGIN = "";
    private static final String PASSWORD = "incorrectPassword";
    private static final String URL = "/login";
    private static final boolean MENU = false;

    public LoginWithBlankLoginAndIncorrectPasswordTest() throws FileNotFoundException {
        super(
                LOGIN,
                PASSWORD,
                URL,
                MENU
        );
    }
}
