package automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines;

import automatedTestsProject.main.core.apiHelpers.ResponseException;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.apache.log4j.Logger;

import java.util.List;

import static org.hamcrest.Matchers.hasKey;

public class BasicSearchEngineResponseOperations {

    private Response response;

    protected static final String ID_KEY = "id";
    private static final String COUNT_OBJECTS_IN_RESPONSE_MESSAGE
            = "Response send from search engine contains %d elements.";
    private static final String MATCH_KEYS_IN_RESPONSE_MESSAGE
            = "Field %s was found in object of ID %s.";
    private static final Logger logger = Logger
            .getLogger(BasicSearchEngineResponseOperations.class);

    public BasicSearchEngineResponseOperations(Response responseValue) {

        this.response = responseValue;
    }

    /**
     * Creates path to object in objects list in json array, by combining "[" and "]" signs with
     * index of object. Result of that operation is "[indexOfObjectInJsonArray]".
     *
     * @param indexOfObjectInJsonArray
     * @return path to object in json array
     */
    private String createPathToObjectInResponse(
            int indexOfObjectInJsonArray){

        String pathToObject = new StringBuilder("[")
                .append(indexOfObjectInJsonArray)
                .append("]")
                .toString();

        return pathToObject;

    }

    /**
     * Gets value of given in parameter keyName key of chosen object in objects list, by using
     * createPathToObjectInResponse() to get to specific object and then gets value assigned to
     * key given in parameter keyName
     *
     * @param indexOfObjectInJsonArray
     * @param keyName
     * @return value of keyName in String
     */
    protected String getKeyValueFromResponse(
            int indexOfObjectInJsonArray,
            String keyName
    ) {

        String valueOfKeyName = response
                .then()
                .extract()
                .path(new StringBuilder()
                        .append(createPathToObjectInResponse(indexOfObjectInJsonArray))
                        .append(".")
                        .append(keyName)
                        .toString())
                .toString();

        return valueOfKeyName;
    }

    /**
     * Counts how many times key appears in json response
     *
     * @param keyName name of key to count
     * @return number of key appearance in json in int
     */
    private int countKeysInResponse(
            String keyName
    ) throws ResponseException {

        try {

            JsonPath pathResponse = response
                    .jsonPath();

            List<String> key = pathResponse
                    .getList(keyName);

            return key.size();

        } catch (NullPointerException e) {

            throw new ResponseException("Response from search engine had incorrect structure.");
        }

    }

    /**
     * Counts how many OMS objects are in json by getting number of id appearance in json response
     *
     * @return number of OMS objects in json response in int
     */
    private int countObjectsInResponseById() throws ResponseException {

        int numberOfObjectsInResponse = countKeysInResponse(ID_KEY);

        logger.info(String.format(COUNT_OBJECTS_IN_RESPONSE_MESSAGE, numberOfObjectsInResponse));

        return numberOfObjectsInResponse;
    }

    /**
     * Matches if all expected flat fields from search engine are present in response
     *
     * @param responseExpectedFields ist of all expected flat fields in object response in String
     */
    public void checkIfAllExpectedFieldsArePresent(
            List <String> responseExpectedFields
    ) throws ResponseException {

        for (int i = 0; i < countObjectsInResponseById(); i ++) {

            String id = getKeyValueFromResponse(i, ID_KEY);

            for (String expectedField : responseExpectedFields) {

                logger.info(String.format(MATCH_KEYS_IN_RESPONSE_MESSAGE, expectedField, id));

                response
                        .then()
                        .body(createPathToObjectInResponse(i), hasKey(expectedField));

            }

        }
    }

}
