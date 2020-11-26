package packageWithAllTests.api.tm.searchEngine;

import automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.BasicSearchEngine;
import automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.BasicSearchEnginesList;
import com.jayway.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class BasicSearchEngineTests {

    private BasicSearchEngine basicSearchEngine;

    public BasicSearchEngineTests(
            BasicSearchEnginesList model
    ) {
        this.basicSearchEngine = model.getSearchEngine();
    }

    @Test
    public void searchEngineListTest() {

        ValidatableResponse validatableResponseForSearchEngine =  basicSearchEngine
                .getListOfSearchEngineObjects()
                .then()
                .assertThat();

        validatableResponseForSearchEngine
                .log()
                .all(true);

        validatableResponseForSearchEngine
                .statusCode(200);

        basicSearchEngine
                .getSearchEngineModelAsArray(validatableResponseForSearchEngine);

    }
}
