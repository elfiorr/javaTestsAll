package automatedTestsProject.main.exampleClassesForApi_Tp;

import automatedTestsProject.main.core.apiHelpers.ParametersFactory;
import automatedTestsProject.main.core.dataMappingConfig.DataConfig;
import automatedTestsProject.main.core.dataMappingConfig.ResourcesPathFactory;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.io.FileNotFoundException;

import static com.jayway.restassured.RestAssured.given;

public class CreatePublicM2mRequest {

    private String apiKey;

    public CreatePublicM2mRequest() {

        try {
            this.apiKey = DataConfig
                    .getUsersData(ResourcesPathFactory
                                    .PATH_TO_URL,
                            "m2m_api_user_key");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Response postJsonToPublicEndpoint(
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
                .post();
    }

    public Response getFromPublicResponse(
            String endpoint
    ) throws FileNotFoundException {

        String devUrl = new StringBuilder()
                .append(EndpointsFactory.m2MApiUrlEndpoint())
                .append(endpoint)
                .toString();

        RestAssured.baseURI = devUrl;

        return createBasicRequestSpecification()
                .when()
                .get();
    }

    public Response getFromPublicDevResponse(
            String endpoint
    ) throws FileNotFoundException {

        String devUrl = new StringBuilder()
                .append(EndpointsFactory.m2MApiUrlEndpoint())
                .append(endpoint)
                .toString();

        RestAssured.baseURI = devUrl;

        return createBasicRequestSpecification()
                .when()
                .get();
    }

    public Response postFormDataToPublicResponse(
            String endpoint,
            String key,
            String value
    ) throws FileNotFoundException {

        String m2mUrl = new StringBuilder()
                .append(EndpointsFactory.m2MApiUrlEndpoint())
                .append(endpoint)
                .toString();

        RestAssured.baseURI = m2mUrl;

        return createRequestSpecificationWithFormData(key, value)
                .when()
                .post();
    }

    private RequestSpecification createRequestSpecificationWithJson(
            JSONObject m2mJSON
    ) {

        return given()
                .header(ParametersFactory.API_KEY, apiKey)
                .contentType(ParametersFactory.APPLICATION_JSON)
                .relaxedHTTPSValidation()
                .body(m2mJSON.toString())
                .log()
                .all();
    }

    private RequestSpecification createBasicRequestSpecification(){

        return given()
                .header(ParametersFactory.API_KEY, apiKey)
                .contentType(ParametersFactory.APPLICATION_JSON)
                .relaxedHTTPSValidation()
                .log()
                .all();
    }

    private RequestSpecification createRequestSpecificationWithFormData(
            String key,
            String value
    ){

        return given()
                .header(ParametersFactory.API_KEY, apiKey)
                .contentType(ParametersFactory.MULTIPART_FORM_DATA)
                .multiPart(key, value)
                .relaxedHTTPSValidation()
                .log()
                .all();
    }
}
