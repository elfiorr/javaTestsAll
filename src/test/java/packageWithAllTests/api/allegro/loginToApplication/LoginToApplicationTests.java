package packageWithAllTests.api.allegro.loginToApplication;

import automatedTestsProject.main.allegro.api.CreateAllegroRequest;
import automatedTestsProject.main.allegro.api.CreateAllegroRequest2;
import automatedTestsProject.main.allegro.api.loginToApplication.LoginToApplicationOperations;
import automatedTestsProject.main.allegro.api.loginToApplication.loginToApplicationResponse.LoginToApplicationResponse;
import com.jayway.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import packageWithAllTests.api.AbstractTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginToApplicationTests extends AbstractTest {

    private ValidatableResponse validatableResponse;
    private CreateAllegroRequest2 createAllegroRequest2 = new CreateAllegroRequest2();
    private CreateAllegroRequest createAllegroRequest = new CreateAllegroRequest();
    private String bearer;
    private int statusCode;
    private String tokenType;
    private boolean allegroApi;
    private int expiresIn;

    public LoginToApplicationTests(
            int statusCode,
            String tokenType,
            boolean allegroApi,
            int expiresIn
    ) {
        this.statusCode = statusCode;
        this.tokenType = tokenType;
        this.allegroApi = allegroApi;
        this.expiresIn = expiresIn;

        this.validatableResponse = new LoginToApplicationOperations()
                .getLoginToApplicationResponse();

        this.bearer = new LoginToApplicationOperations()
                .getBearerToken();
    }

    @BeforeEach
    public void setUp() {
        validatableResponse
                .log()
                .all();
    }

    @Test
    public void checkLoginToApplicationHttpStatusCode() {

        validatableResponse
                .statusCode(statusCode);
    }

    @Test
    public void checkLoginToApplicationStructure() {

        getAccountsResponseJsonModel();
    }

    @Test
    public void verifyTokenTypeForLoginToApplication(){

        assertEquals(
                tokenType,
                getAccountsResponseJsonModel()
                        .getTokenType(),
                NOT_CORRECT_RESPONSE);
    }

    @Test
    public void verifyIsAllegroApiForLoginToApplication(){

        assertEquals(
                allegroApi,
                getAccountsResponseJsonModel()
                        .isAllegroApi(),
                NOT_CORRECT_RESPONSE);
    }

    @Test
    public void verifyIsExpiresInValueIsCorrectForLoginToApplication(){

        assertEquals(
                expiresIn,
                getAccountsResponseJsonModel()
                        .getExpiresIn(),
                NOT_CORRECT_RESPONSE);
    }
//    @Test
//    public void sss() {
//
//        createAllegroRequest2
//                .createRequestSpecificationTokenToAllegro("78eca2052c4341f39862e7ddeb69f6d4",
//                        "BLGT82iSqLj38uBGhlnKnl84CWIHc4soOmAAgbsoRxciVuulRYvUnYhS7B0P54hW");
//
//    }
//
//    @Test
//    public void sss2() {
//
//        createAllegroRequest
//                .getTokenForApplicationFromAllegro(ALLEGRO_OAUTH_TOKEN);
//
//    }

    private LoginToApplicationResponse getAccountsResponseJsonModel() {

        return validatableResponse
                .extract()
                .as(LoginToApplicationResponse.class);
    }
}
