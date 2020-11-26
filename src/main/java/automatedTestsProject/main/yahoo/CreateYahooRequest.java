package automatedTestsProject.main.yahoo;

import com.jayway.restassured.response.ValidatableResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static com.jayway.restassured.RestAssured.given;

public class CreateYahooRequest {

    private static final Log log = LogFactory.getLog(CreateYahooRequest.class);

    public static ValidatableResponse createRequestSpecificationTokenToYahoo(
            String clientId,
            String clientSecret
    ) {

        String redirect_uri = "https://exemplary2.redirect.uri.com";
        String code = "hqxn5md";
        String grantType = "authorization_code";

        String body = String.format("grant_type=%s&code=%s&redirect_uri=%s", grantType, code, redirect_uri);

        return given().auth().preemptive().basic(clientId, clientSecret)
                .queryParams("client_id", clientId)
                .queryParams("client_secret", clientSecret)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .body(body)
                .when()
                .post("https://api.login.yahoo.com/oauth2/get_token")
                .then()
                .log()
                .all();
    }
}
