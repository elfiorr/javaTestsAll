package automatedTestsProject.main.allegro.api;

import automatedTestsProject.main.yahoo.CreateYahooRequest;
import com.jayway.restassured.response.ValidatableResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static com.jayway.restassured.RestAssured.given;

public class CreateAllegroRequest2 {


    private static final Log log = LogFactory.getLog(CreateYahooRequest.class);

    public static ValidatableResponse createRequestSpecificationTokenToAllegro(
            String clientId,
            String clientSecret
    ) {

        String grantType = "client_credentials";

        String body = String.format("grant_type=%s", grantType);

        return given()
                .auth()
                .preemptive()
                .basic(clientId, clientSecret)
                .queryParams("client_id", clientId)
                .queryParams("client_secret", clientSecret)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .body(body)
                .when()
                .post("https://allegro.pl.allegrosandbox.pl/auth/oauth/token")
                .then()
                .log()
                .all();
    }
}
