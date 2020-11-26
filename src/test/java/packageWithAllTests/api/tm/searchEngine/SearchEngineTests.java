package packageWithAllTests.api.tm.searchEngine;

import automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.SearchEngine;
import automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.SearchEnginesList;
import com.jayway.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class SearchEngineTests implements TestHelper{

    private SearchEngine searchEngine;
    private SearchEnginesList model;

    public SearchEngineTests(
            SearchEnginesList model
    ) {
        this.model = model;
        this.searchEngine = model.getSearchEngine();
    }

    @Test
    public void searchEngineListTest() {

        ValidatableResponse validatableResponseForSearchEngine =  searchEngine
                .getListOfSearchEngineObjects()
                .then()
                .assertThat();

        validatableResponseForSearchEngine
                .log()
                .all(true);

        validatableResponseForSearchEngine
                .statusCode(200);

        searchEngine
                .getSearchEngineModelAsArray(validatableResponseForSearchEngine);

    }

    @Test
    public void searchEngineGetObjectByIdTest(){

        searchEngine
                .getListOfAllIdsInResponse()
                .forEach(objectId
                        ->
                {

                    responseFromOneObjectExpectedBehavior(
                            searchEngine,
                            model
                                    .getSearchEngine()
                                    .getSearchEngineObject(
                                            "id",
                                            objectId.toString()));

                });

    }

    @Test
    public void searchEngineGetObjectByProductSlugTest(){

        searchEngine
                .getListOfAllProductSlugsInResponse()
                .forEach(objectProductSlug
                        ->
                {

                    responseFromOneObjectExpectedBehavior(
                            searchEngine,
                            model
                                    .getSearchEngine()
                                    .getSearchEngineObject(
                                            "productSlug",
                                            objectProductSlug.toString()));
                });
    }

}
