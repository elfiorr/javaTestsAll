package automatedTestsProject.main.allegro.api;

import automatedTestsProject.main.core.apiHelpers.ParametersFactory;
import automatedTestsProject.main.core.dataMappingConfig.DataConfig;
import automatedTestsProject.main.core.dataMappingConfig.ResourcesPathFactory;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;

import static automatedTestsProject.main.core.apiHelpers.ParametersFactory.*;
import static com.jayway.restassured.RestAssured.given;

public class CreateAllegroRequest {

    private String urlAllegroSandbox;
    private DataConfig dataConfig = new DataConfig();

    public CreateAllegroRequest() {
        try {
            this.urlAllegroSandbox = DataConfig
                    .getConnectionData(
                            ResourcesPathFactory.APPLICATIONS_PATH,
                            "allegro_api_sandbox_url");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Response getFromAllegroResponseWithoutParamAndBearer(
            String endpoint
    ) {

        return createRequestSpecificationToAllegroSandboxWithEndpoint(endpoint)
                .when()
                .get();
    }

    public Response getFromAllegroResponseWithOneParamWithoutBearer(
            String endpoint,
            String param,
            String paramValue
    ) {

        return createRequestSpecificationToAllegroSandboxWithEndpoint(endpoint)
                .param(param, paramValue)
                .when()
                .get();
    }


    public Response getFromAllegroResponseWithOneParamAndBearerAuth(
            String endpoint,
            String param,
            String paramValue,
            String bearer
    ) {

        return createRequestSpecificationToAllegroSandboxWithEndpointAndBearer(endpoint, bearer)
                .param(param, paramValue)
                .when()
                .get();
    }

    public ValidatableResponse getTokenForApplicationFromAllegro(String endpoint) {

        return createRequestAuthSpecificationToGetAllegroToken()
                .when()
                .post(endpoint)
                .then()
                .log()
                .all();
    }

    private RequestSpecification createRequestAuthSpecificationToGetAllegroToken(
    ) {

        RestAssured.baseURI = dataConfig
                .getConnectionData(
                        ResourcesPathFactory.APPLICATIONS_PATH,
                        "allegro_sandbox_url");

        String clientId = dataConfig
                .getUsersData(
                        ResourcesPathFactory.APPLICATIONS_PATH,
                        "allegro_TestyRestApiAllegro_client_id");

        String clientSecret = dataConfig
                .getUsersData(
                        ResourcesPathFactory.APPLICATIONS_PATH,
                        "allegro_TestyRestApiAllegro_client_secret");

        return given()
                .auth()
                .preemptive()
                .basic(clientId, clientSecret)
                .queryParams("client_id", clientId)
                .queryParams("client_secret", clientSecret)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .body(GRANT_TYPE);
    }

    private RequestSpecification createRequestSpecificationToAllegroSandboxWithEndpointAndBearer(
            String endpoint,
            String bearer
    ) {

        RestAssured.baseURI = dataConfig
                .getConnectionData(
                        ResourcesPathFactory.APPLICATIONS_PATH,
                        "allegro_api_sandbox_url")
                .concat(endpoint);

        return given()
                .headers(ParametersFactory.ACCEPT, ParametersFactory.APPLICATION_VND,
                        "Authorization", "Bearer " + bearer)
                .relaxedHTTPSValidation()
                .log()
                .all();
    }

    private RequestSpecification createRequestSpecificationToAllegroSandboxWithEndpoint(
            String endpoint
    ) {

        RestAssured.baseURI = dataConfig
                .getConnectionData(
                        ResourcesPathFactory.APPLICATIONS_PATH,
                        "allegro_api_sandbox_url")
                .concat(endpoint);

        return given()
                .headers(ParametersFactory.ACCEPT, ParametersFactory.APPLICATION_VND)
                .relaxedHTTPSValidation()
                .log()
                .all();
    }

//    private RequestSpecification createRequestSpecificationWithJson(
////            JSONObject jsonObject
//    ) {
//
//        return given()
//                .header(ParametersFactory.ACCEPT, ParametersFactory.APPLICATION_VND)
//                .contentType(ParametersFactory.APPLICATION_JSON)
//                .relaxedHTTPSValidation()
////                .body(jsonObject.toString())
//                .log()
//                .all();
//    }
}
