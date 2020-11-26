package packageWithAllTests.ui.tpExamplesTests.tpWithoutCucumber.loginTests;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.framePages.MainHeaderPage;
import automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.loginPages.LoginPage;
import packageWithAllTests.ui.tpExamplesTests.tpWithoutCucumber.AbstractTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;

public class LoginTests extends AbstractTest {

    private String login;
    private String password;
    private String url;
    private boolean isMenuVisible;
    private LoginPage loginPage = new LoginPage(driver);
    private MainHeaderPage mainHeaderPage = new MainHeaderPage(driver);

    public LoginTests(
            String login,
            String password,
            String url,
            boolean isMenuVisible
    ) throws FileNotFoundException {
        this.login = login;
        this.password = password;
        this.url = url;
        this.isMenuVisible = isMenuVisible;
    }

//    @Test
//    public void loginTest(){
//
//        driver.get(TP_LOGIN_URL);
//
//        loginPage.setUserName(login);
//        loginPage.setPassword(password);
//        loginPage.clickLoginButton();
//
//        Assertions.assertEquals(isMenuVisible,
//                mainHeaderPage.isUserMenuButtonDisplayed()
//                        && mainHeaderPage.isNavigationTopBarDisplayed(),
//                AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE);
//
//        Assertions.assertEquals(TP_LOGIN_URL.concat(url),
//                driver.getCurrentUrl(),
//                AbstractStepdefs.CHECK_URL_ASSERT_MESSAGE);
//    }
}
