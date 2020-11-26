package automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines;

import automatedTestsProject.main.core.apiHelpers.JsonHelper;
import automatedTestsProject.main.core.apiHelpers.ParametersFactory;
import automatedTestsProject.main.core.apiHelpers.RequestSpecificationHelper;
import automatedTestsProject.main.core.apiHelpers.ResponseException;
import automatedTestsProject.main.core.dataMappingConfig.DataConfig;
import automatedTestsProject.main.core.dataMappingConfig.ResourcesPathFactory;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import static com.jayway.restassured.RestAssured.given;

public class CreateNotConnectedSearchEngineRequest {

    private final String searchEngine;
    private final String apiKey;
    private String omsApiUrl;

    public CreateNotConnectedSearchEngineRequest(
            String searchEngineValue,
            String apiKeyValue
    ) {

        this.searchEngine = searchEngineValue;
        this.apiKey = apiKeyValue;

        try {
            this.omsApiUrl = new StringBuilder()
                    .append(DataConfig.getConnectionData(
                            ResourcesPathFactory.PATH_TO_URL,
                            "tp_url"))
                    .append("/api/oms")
                    .append("/")
                    .toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private RequestSpecification createRequestSpecification() {

            return given()
                    .header(ParametersFactory.API_KEY, apiKey)
                    .contentType(ParametersFactory.APPLICATION_JSON)
                    .relaxedHTTPSValidation()
                    .log()
                    .all();
    }

    private RequestSpecification createRequestSpecificationWithJson(
            JSONObject searchEngineJSON
    ) throws ResponseException {

        try {
        return given()
                .header(ParametersFactory.API_KEY, apiKey)
                .contentType(ParametersFactory.APPLICATION_JSON)
                .relaxedHTTPSValidation()
                .body(searchEngineJSON.toString())
                .log()
                .all();

        } catch (IllegalArgumentException e) {

            throw new ResponseException(ParametersFactory.APIKEY_NOT_PROVIDED_MESSAGE);
        }
    }

    public Response postToSearchEngine() throws ResponseException {

        String searchEngineUrl = new StringBuilder()
                .append(omsApiUrl)
                .append(searchEngine)
                .toString();

        RestAssured.baseURI = searchEngineUrl;

        return createRequestSpecification()
                .when()
                .post();
    }

    public Response postToSearchEngineWithJson() throws IOException, ResponseException {

        JSONObject searchEngineJSON = JsonHelper
                .readJSONtoJSONObject(
                        ResourcesPathFactory.PATH_TO_URL,
                        searchEngine);

        String searchEngineUrl = new StringBuilder()
                .append(omsApiUrl)
                .append(searchEngine)
                .toString();

        RestAssured.baseURI = searchEngineUrl;

        return createRequestSpecificationWithJson(searchEngineJSON)
                .when()
                .post();

    }

    /**
     * NOWY MODEL
     */

    private RequestSpecification createRequestSpecificationWithJSON(
            JSONObject searchEngineJSON
    ) {

            return given()
                    .header(ParametersFactory.API_KEY, apiKey)
                    .contentType(ParametersFactory.APPLICATION_JSON)
                    .relaxedHTTPSValidation()
                    .body(searchEngineJSON.toString())
                    .log()
                    .all();
    }

    public Response postToSearchEngineWithJSON(
            JSONObject searchEngineJSON
    ) {

        String searchEngineUrl = new StringBuilder()
                .append(omsApiUrl)
                .append(searchEngine)
                .toString();

        RestAssured.baseURI = searchEngineUrl;

        return createRequestSpecificationWithJSON(searchEngineJSON)
                .when()
                .post();

    }

    private RequestSpecification createRequestSpecificationWithParamsFromJSONObject(
            JSONObject searchEngineJSON
    ) {

        HashMap<String, Object> mapOfParamsFromJSONObject = RequestSpecificationHelper
                .createMapBasedOfJSONObject(searchEngineJSON);

        return RequestSpecificationHelper
                .createRequestSpecificationWithParams(
                        createRequestSpecification(),
                        mapOfParamsFromJSONObject);

    }

    public Response getFromSearchEngineForObjectWithParamsFromJSON(
            String key,
            String value,
            JSONObject searchEngineJSON
    ) {

        String searchEngineUrl = new StringBuilder()
                .append(omsApiUrl)
                .append(searchEngine)
                .append("/")
                .append(key)
                .append("/")
                .append(value)
                .toString();

        RestAssured.baseURI = searchEngineUrl;

        return createRequestSpecificationWithParamsFromJSONObject(searchEngineJSON)
                .when()
                .get();
    }
}
