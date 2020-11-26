package packageWithAllTests.api.tm.m2m.registration.firstLogin;

import automatedTestsProject.main.exampleClassesForApi_Tp.getDetails.GetDetailsOperations;
import automatedTestsProject.main.exampleClassesForApi_Tp.getDetails.GetDetailsResponseJsonModel;
import automatedTestsProject.main.exampleClassesForApi_Tp.login.LoginOperations;
import automatedTestsProject.main.exampleClassesForApi_Tp.login.LoginResponseJsonModel;
import automatedTestsProject.main.exampleClassesForApi_Tp.partnerFactories.Partner;
import automatedTestsProject.main.exampleClassesForApi_Tp.registration.activate.ActivateOperations;
import automatedTestsProject.main.exampleClassesForApi_Tp.registration.firstLogin.FirstLoginOperations;
import automatedTestsProject.main.exampleClassesForApi_Tp.registration.register.AccountTypes;
import automatedTestsProject.main.exampleClassesForApi_Tp.registration.register.RegisterOperations;
import automatedTestsProject.main.exampleClassesForApi_Tp.registration.register.RegisterTypes;
import com.jayway.restassured.response.ValidatableResponse;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import packageWithAllTests.api.AbstractTest;

import java.io.FileNotFoundException;

public class FirstLoginTests extends AbstractTest {

    private ValidatableResponse validatableResponseFromFirstLogin;
    private Partner partner;
    private String email;
    private String subdomain;

    public FirstLoginTests(
            RegisterTypes registerType,
            Partner partner,
            AccountTypes accountType
    ) throws FileNotFoundException {

        this.email = partner.getEmail();
        partner.setSubdomain("subdomain"
                .concat(DateTime.now().withZone(DateTimeZone.UTC).toString("yyyyMMddHHmmss")));
        this.subdomain = partner.getSubdomain();
        this.partner = partner;

        new RegisterOperations(
                registerType,
                this.partner,
                accountType)
                .registerNewUser()
                .then()
                .assertThat()
                .log()
                .all(true);

        new ActivateOperations(
                this.partner.getEmail())
                .getRegisterActivateResponse()
                .then()
                .assertThat()
                .log()
                .all(false);

        this.validatableResponseFromFirstLogin = new FirstLoginOperations(
                new LoginOperations(email).getUserBearer(),
                partner,
                accountType)
                .getResponseFromFirstLogin()
                .then()
                .assertThat();
    }

    @BeforeEach
    public void setUp() {

        validatableResponseFromFirstLogin
                .log()
                .all(true)
                .statusCode(200)
                .extract()
                .as(LoginResponseJsonModel.class);
    }

    @Test
    public void firstLoginLogNewUserWithUsernameTest() throws FileNotFoundException {

        String tokenFromUsernameLogin = new LoginOperations(subdomain)
                .getUserLoginResponse()
                .then()
                .assertThat()
                .extract()
                .as(LoginResponseJsonModel.class)
                .getToken();

        new GetDetailsOperations(
                tokenFromUsernameLogin)
                .getDetails()
                .then()
                .assertThat()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .as(GetDetailsResponseJsonModel.class);
    }

    @Test
    public void firstLoginLogNewUserWithEmailTest() throws FileNotFoundException {

        String tokenFromMailLogin = new LoginOperations(email)
                .getUserLoginResponse()
                .then()
                .assertThat()
                .extract()
                .as(LoginResponseJsonModel.class)
                .getToken();

        new GetDetailsOperations(
                tokenFromMailLogin)
                .getDetails()
                .then()
                .assertThat()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .as(GetDetailsResponseJsonModel.class);
    }

    @Test
    public void firstLoginLogNewUserWithTokenTest() throws FileNotFoundException {

        new GetDetailsOperations(
                getFirstLoginResponseJsonModel()
                        .getToken())
                .getDetails()
                .then()
                .assertThat()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .as(GetDetailsResponseJsonModel.class);
    }

    private LoginResponseJsonModel getFirstLoginResponseJsonModel() {

        return validatableResponseFromFirstLogin
                .extract()
                .as(LoginResponseJsonModel.class);
    }


}
