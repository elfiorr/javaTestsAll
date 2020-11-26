package automatedTestsProject.main.countryApi;

import automatedTestsProject.main.core.dataMappingConfig.DataConfig;
import automatedTestsProject.main.core.dataMappingConfig.ResourcesPathFactory;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static com.jayway.restassured.RestAssured.given;
import static springProject.springBoot1.EndpointFactory.COUNTRY;

public class CreateCountryRequest {

    private String localUrl;
    private DataConfig dataConfig = new DataConfig();

    public CreateCountryRequest() {
        try {
            this.localUrl = DataConfig
                    .getConnectionData(
                            ResourcesPathFactory.APPLICATIONS_PATH,
                            "local_url");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Response getFromLocalResponseWithoutParam(
            String endpoint
    ) {

        return createRequestSpecificationToLocalWithEndpoint(endpoint)
                .when()
                .get();
    }

    public Response postFromLocalResponseWithoutParamAndWithJson(
            String endpoint,
            JSONObject countryJSON

    ) {

        return createRequestSpecificationToLocalWithEndpointAndJson(endpoint, countryJSON)
                .when()
                .post();
    }

    private RequestSpecification createRequestSpecificationToLocalWithEndpoint(
            String endpoint
    ) {

        RestAssured.baseURI = dataConfig
                .getConnectionData(
                        ResourcesPathFactory.APPLICATIONS_PATH,
                        "local_url")
                .concat(COUNTRY)
                .concat(endpoint);

        return given()
                .log()
                .all();
    }

    private RequestSpecification createRequestSpecificationToLocalWithEndpointAndJson(
            String endpoint,
            JSONObject countryJSON
    ) {

        RestAssured.baseURI = dataConfig
                .getConnectionData(
                        ResourcesPathFactory.APPLICATIONS_PATH,
                        "local_url")
                .concat(COUNTRY)
                .concat(endpoint);

        return given()
                .body(countryJSON.toString())
                .contentType("application/json")
                .log()
                .all();
    }
}
