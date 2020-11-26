package automatedTestsProject.main.exampleClassesForApi_Tp;

import automatedTestsProject.main.core.apiHelpers.ParametersFactory;
import automatedTestsProject.main.core.apiHelpers.RequestSpecificationHelper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.util.HashMap;

import static com.jayway.restassured.RestAssured.given;

public class CreateUserM2mRequest {

    private String bearer;

    public CreateUserM2mRequest(
            String bearerValue
    ) {
        this.bearer = bearerValue;
    }

    public Response putJsonToUserEndpoint(
            String endpoint,
            JSONObject m2mJSON
    ) throws FileNotFoundException {

        String m2mUrl = new StringBuilder()
                .append(EndpointsFactory.m2MApiUrlEndpoint())
                .append(endpoint)
                .toString();

        RestAssured.baseURI = m2mUrl;

        return createRequestSpecificationWithJson(m2mJSON)
                .when()
                .put();
    }

    public Response getFromUserEndpoint(
            String endpoint
    ) throws FileNotFoundException {

        String m2mUrl = new StringBuilder()
                .append(EndpointsFactory.m2MApiUrlEndpoint())
                .append(endpoint)
                .toString();

        RestAssured.baseURI = m2mUrl;

        return createRequestSpecification()
                .when()
                .get();
    }

    public Response getWithParamsFromUserEndpoint(
            String endpoint,
            HashMap<String, Object> mapOfParams
    ) throws FileNotFoundException {

        String m2mUrl = new StringBuilder()
                .append(EndpointsFactory.m2MApiUrlEndpoint())
                .append(endpoint)
                .toString();

        RestAssured.baseURI = m2mUrl;

        return createRequestSpecificationWithParameters(mapOfParams)
                .when()
                .get();
    }

    public Response postToUserEndpoint(
            String endpoint
    ) throws FileNotFoundException {

        String m2mUrl = new StringBuilder()
                .append(EndpointsFactory.m2MApiUrlEndpoint())
                .append(endpoint)
                .toString();

        RestAssured.baseURI = m2mUrl;

        return createRequestSpecification()
                .when()
                .post();
    }

    public Response postToUserEndpoint(
            String endpoint,
            JSONObject m2mJSONObject
    ) throws FileNotFoundException {

        String m2mUrl = new StringBuilder()
                .append(EndpointsFactory.m2MApiUrlEndpoint())
                .append(endpoint)
                .toString();

        RestAssured.baseURI = m2mUrl;

        return createRequestSpecificationWithJson(m2mJSONObject)
                .when()
                .post();
    }

    private RequestSpecification createRequestSpecificationWithJson(
            JSONObject m2mJSON
    ) {

        return given()
                .header(ParametersFactory.AUTHORIZATION,
                        new StringBuilder()
                                .append(ParametersFactory.BEARER)
                                .append(" ")
                                .append(bearer)
                                .toString())
                .contentType(ParametersFactory.APPLICATION_JSON)
                .relaxedHTTPSValidation()
                .body(m2mJSON.toString())
                .log()
                .all();
    }

    private RequestSpecification createRequestSpecification() {

        return given()
                .header(ParametersFactory.AUTHORIZATION,
                        new StringBuilder()
                                .append(ParametersFactory.BEARER)
                                .append(" ")
                                .append(bearer)
                                .toString())
                .contentType(ParametersFactory.APPLICATION_JSON)
                .relaxedHTTPSValidation()
                .log()
                .all();
    }

    private RequestSpecification createRequestSpecificationWithParameters(
            HashMap<String, Object> mapOfParams
    ) {

        return RequestSpecificationHelper.createRequestSpecificationWithParams(
                createRequestSpecification(),
                mapOfParams);
    }
}
