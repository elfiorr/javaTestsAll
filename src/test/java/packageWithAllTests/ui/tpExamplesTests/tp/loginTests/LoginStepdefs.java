package packageWithAllTests.ui.tpExamplesTests.tp.loginTests;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.loginPages.LoginPage;
import packageWithAllTests.ui.tpExamplesTests.AbstractStepdefs;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;

import java.sql.Timestamp;

public class LoginStepdefs {

    private String FEATURE_NAME = "Test: "
            .concat(new Timestamp(System.currentTimeMillis())
                    .toString());
    private AbstractStepdefs abstractStepdefs;
    private Scenario scenario;
    private LoginPage loginPage;

    public LoginStepdefs(AbstractStepdefs abstractStepdefs) {
        this.abstractStepdefs = abstractStepdefs;
    }

    @After
    public void closeDriver() {

        if (scenario != null) {
            abstractStepdefs
                    .after(scenario);
        }
    }

    @Given("Jestem na stronie logowania do aplikacji")
    public void jestem_na_stronie_logowania_do_aplikacji() {

//        abstractStepdefs.startBrowser(FEATURE_NAME);
//        loginPage = new LoginPage(abstractStepdefs.getDriver());
//        abstractStepdefs.getDriver()
//                .get(abstractStepdefs.TP_LOGIN_URL);
    }

    @Given("Loguje sie do aplikacji totalpanel")
    public void loguje_sie_do_aplikacji_totalpanel() {
//
//        loginPage
//                .logIn(abstractStepdefs.TP_USERNAME,
//                        abstractStepdefs.TP_PASSWORD);
    }
}
