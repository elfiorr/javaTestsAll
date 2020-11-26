package packageWithAllTests.api.tm.searchEngine;

import automatedTestsProject.main.core.apiHelpers.ResponseException;
import automatedTestsProject.main.core.dataMappingConfig.DataConfig;
import automatedTestsProject.main.core.dataMappingConfig.ResourcesPathFactory;
import automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.BasicSearchEngineResponseOperations;
import automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.CreateNotConnectedSearchEngineRequest;
import automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.NotConnectedSearchEnginesModel;
import com.jayway.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class BasicNotConnectedSearchEnginesTests {

    private NotConnectedSearchEnginesModel model;

    public BasicNotConnectedSearchEnginesTests(
            NotConnectedSearchEnginesModel modelValue
    ) {
        this.model = modelValue;
    }

    @Test
    public void matchIfAllOfExpectedFieldsArePresent()
            throws IOException, ResponseException {

        Response listOfAllObjects = new CreateNotConnectedSearchEngineRequest(
                model.getSearchEngineName(),
                model.getSearchEngineApiKey())
                .postToSearchEngine();

        listOfAllObjects.then().log().all(true);

        List<String> listOfAllExpectedFields = DataConfig
                .getListParamFromResourcesFile(
                        ResourcesPathFactory.TOTALPANEL_TARGET_SCREENSHOTS_RESOURCES_PATH,
                        model.getSearchEngineName(),
                        "fields");

        new BasicSearchEngineResponseOperations(listOfAllObjects)
                .checkIfAllExpectedFieldsArePresent(listOfAllExpectedFields);

    }
}
