package automatedTestsProject.main.wows.api;

import automatedTestsProject.main.core.apiHelpers.RequestSpecificationHelper;
import automatedTestsProject.main.core.dataMappingConfig.DataConfig;
import automatedTestsProject.main.core.dataMappingConfig.ResourcesPathFactory;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import java.util.HashMap;

import static com.jayway.restassured.RestAssured.given;

public class CreateWowsRequest {

    private String urlWows;
    private DataConfig dataConfig = new DataConfig();

    public CreateWowsRequest() {

        try {
            this.urlWows = dataConfig
                    .getConnectionData(
                            ResourcesPathFactory.APPLICATIONS_PATH,
                            "wows_eu_url");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Response getFromPublicResponseWithoutParam(
            String endpoint
    ) {

        return createRequestSpecificationToWowsWithEndpoint(endpoint)
                .when()
                .get();
    }

    public Response getFromPublicResponseWithOneParam(
            String endpoint,
            String param,
            String paramValue
    ) {

        return createRequestSpecificationToWowsWithEndpoint(endpoint)
                .param(param, paramValue)
                .when()
                .get();
    }

    public Response postFromPublicResponseWithOneParam(
            String endpoint,
            HashMap<String, Object> mapOfParams
    ) {

        return createRequestSpecificationWithParams(endpoint, mapOfParams)
                .when()
                .post();
    }

    private RequestSpecification createRequestSpecificationWithParams(
            String endpoint,
            HashMap<String, Object> mapOfParams
    ) {

        return RequestSpecificationHelper.createRequestSpecificationWithParams(
                createRequestSpecificationToWowsWithEndpoint(endpoint),
                mapOfParams);
    }

    private RequestSpecification createRequestSpecificationToWowsWithEndpoint(
            String endpoint) {

        RestAssured.baseURI = dataConfig
                .getConnectionData(
                        ResourcesPathFactory.APPLICATIONS_PATH,
                        "wows_eu_url")
                .concat(endpoint);

        return given()
                .param("application_id", dataConfig
                        .getUsersData(
                                ResourcesPathFactory.APPLICATIONS_PATH,
                                "wows_eu_application_id_first"))
                .log()
                .all();

    }
}


