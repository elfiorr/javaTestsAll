package packageWithAllTests.api.tm.m2m.registration.activate;

import automatedTestsProject.main.exampleClassesForApi_Tp.login.LoginResponseJsonModel;
import automatedTestsProject.main.exampleClassesForApi_Tp.partnerFactories.Partner;
import automatedTestsProject.main.exampleClassesForApi_Tp.registration.activate.ActivateOperations;
import automatedTestsProject.main.exampleClassesForApi_Tp.registration.register.AccountTypes;
import automatedTestsProject.main.exampleClassesForApi_Tp.registration.register.RegisterOperations;
import automatedTestsProject.main.exampleClassesForApi_Tp.registration.register.RegisterTypes;
import com.jayway.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import packageWithAllTests.api.AbstractTest;

import java.io.FileNotFoundException;

public class ActivateTests extends AbstractTest {

    private ValidatableResponse validatableResponseFromActivateEndpoint;
    private Partner partner;

    public ActivateTests(
            RegisterTypes registerType,
            Partner partner,
            AccountTypes accountType
    ) throws FileNotFoundException {

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

        this.validatableResponseFromActivateEndpoint = new ActivateOperations(
                this.partner.getEmail())
                .getRegisterActivateResponse()
                .then()
                .assertThat();
    }

    @BeforeEach
    private void setUp(){

        validatableResponseFromActivateEndpoint
                .log()
                .all();
    }

    private LoginResponseJsonModel getResponseJsonModel() {

        return validatableResponseFromActivateEndpoint
                .extract()
                .as(LoginResponseJsonModel.class);
    }

    @Test
    public void activateResponseStatusCodeTest() {

        validatableResponseFromActivateEndpoint
                .statusCode(200);
    }

    @Test
    public void activateResponseResponseJsonModelTest() {

        getResponseJsonModel();
    }


}
