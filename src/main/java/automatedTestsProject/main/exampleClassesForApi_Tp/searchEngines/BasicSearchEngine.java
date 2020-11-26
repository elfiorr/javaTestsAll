package automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;

public abstract class BasicSearchEngine<T> {

    public abstract Response getListOfSearchEngineObjects();

    public abstract T getSearchEngineModel(
            ValidatableResponse validatableResponse);

    public abstract T[] getSearchEngineModelAsArray(
            ValidatableResponse validatableResponse);

}

