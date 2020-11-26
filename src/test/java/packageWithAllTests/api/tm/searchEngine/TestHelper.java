package packageWithAllTests.api.tm.searchEngine;

import automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.SearchEngine;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;

import static org.junit.jupiter.api.Assertions.assertTrue;

public interface TestHelper {

    String INCORRECT_PARAMETERS_GIVEN_MESSAGE
            = "Product exists, but incorrect parameters given.";

    default void responseFromOneObjectExpectedBehavior(
            SearchEngine searchEngine,
            Response response
    ) {
        ValidatableResponse validatableResponse = response
                .then()
                .assertThat();


        if (response.statusCode() == 200) {

            searchEngine
                    .getSearchEngineModel(validatableResponse);

        } else {

            validatableResponse.statusCode(400);

            assertTrue(
                    response
                            .prettyPrint()
                            .contains(INCORRECT_PARAMETERS_GIVEN_MESSAGE),
                    "Object do not has correct message.");
        }

    }
}
