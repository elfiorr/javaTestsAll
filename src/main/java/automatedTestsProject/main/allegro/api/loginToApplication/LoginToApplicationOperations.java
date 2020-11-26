package automatedTestsProject.main.allegro.api.loginToApplication;

import automatedTestsProject.main.allegro.api.CreateAllegroRequest;
import automatedTestsProject.main.allegro.api.loginToApplication.loginToApplicationResponse.LoginToApplicationResponse;
import com.jayway.restassured.response.ValidatableResponse;

import static automatedTestsProject.main.exampleClassesForApi_Tp.EndpointsFactory.ALLEGRO_OAUTH_TOKEN;

public class LoginToApplicationOperations extends CreateAllegroRequest {

    private ValidatableResponse validatableResponse;
    private String bearer;

    public LoginToApplicationOperations(
    ) {
        this.validatableResponse = getTokenForApplicationFromAllegro(
                ALLEGRO_OAUTH_TOKEN);
    }

    /**
     * Send authorization token as form data to activation endpoint and activates application
     *
     * @return Response form authorization endpoint
     */
    public ValidatableResponse getLoginToApplicationResponse() {

        return validatableResponse;
    }

    /**
     * Extract user token from validatableResponse from authorization endpoint
     *
     * @return
     */
    public String getBearerToken() {

        return validatableResponse
                .extract()
                .as(LoginToApplicationResponse.class)
                .getAccessToken();
    }
}
