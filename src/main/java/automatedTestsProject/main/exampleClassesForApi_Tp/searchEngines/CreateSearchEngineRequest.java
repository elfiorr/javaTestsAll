package automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines;

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
import java.util.HashMap;

import static com.jayway.restassured.RestAssured.given;

public class CreateSearchEngineRequest {

    private String searchEngine;
    private String apiKey;
    private String omsApiUrl;

    public CreateSearchEngineRequest(
            String searchEngine
    ) {

        this.searchEngine = searchEngine;
        this.apiKey = getApiKey();
        try {
            this.omsApiUrl = DataConfig.getConnectionData(
                    ResourcesPathFactory.PATH_TO_URL,
                    "tp_url")
                    .concat("/api/oms/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends a request for a list of objects, returned based on search parameters described in json.
     *
     * @param searchEngineJSON json with parameters for which we want to search for an objects list
     *                         (on their basis calculated fields and values from margins are returned)
     * @return
     */
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

    /**
     * Sends a request for a list of objects without JSON
     *
     * @return
     */
    public Response postToSearchEngine() {

        String searchEngineUrl = new StringBuilder()
                .append(omsApiUrl)
                .append(searchEngine)
                .toString();

        RestAssured.baseURI = searchEngineUrl;

        return createRequestSpecification()
                .when()
                .post();
    }

    /**
     * Sends a request for a single object (key value identified by pair) and returns it in the form
     * of a REST Assured response
     *
     * @param key              name of the field in the object to search
     * @param value            field (key) value in the object for which we want to search
     * @param searchEngineJSON json with parameters for which we want to search for an object
     *                         (on their basis calculated fields and values from margins are returned)
     * @return
     */
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

    /**
     * Sends a request for a single object (key value identified by pair) and returns it in the form
     * of a REST Assured response
     *
     * @param key   name of the field in the object to search
     * @param value field (key) value in the object for which we want to search
     * @return
     */
    public Response getFromSearchEngineForObject(
            String key,
            String value
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

        return createRequestSpecification()
                .when()
                .get();
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

    private RequestSpecification createRequestSpecification() {

        return given()
                .header(ParametersFactory.API_KEY, apiKey)
                .contentType(ParametersFactory.APPLICATION_JSON)
                .relaxedHTTPSValidation()
                .log()
                .all();
    }

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

    private static String getApiKey() {

        String apiKey = System.getProperty("API_KEY_SEARCH_ENGINE");

        if (apiKey == null) {
            try {
                throw new ResponseException("API_KEY_SEARCH_ENGINE was not provided. Tests aborded.");
            } catch (ResponseException e) {
                e.printStackTrace();
            }
        }

        return apiKey;
    }
}
