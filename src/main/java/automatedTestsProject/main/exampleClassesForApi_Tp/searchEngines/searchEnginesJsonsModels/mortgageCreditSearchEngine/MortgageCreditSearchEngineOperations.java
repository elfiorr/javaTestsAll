package automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.searchEnginesJsonsModels.mortgageCreditSearchEngine;

import automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.CreateSearchEngineRequest;
import automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.SearchEngine;
import automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.SearchEnginesList;
import automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.searchEnginesJsonsModels.mortgageCreditSearchEngine.mortgageCreditSearchEngineRequestJsonModel.MortgageCreditSearchEngineRequestDataFactory;
import automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.searchEnginesJsonsModels.mortgageCreditSearchEngine.mortgageCreditSearchEngineResponseModel.MortgageCreditSearchEngineResponseJsonModel;
import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MortgageCreditSearchEngineOperations extends SearchEngine<MortgageCreditSearchEngineResponseJsonModel> {

    @Override
    public List<String> getListOfAllIdsInResponse() {

        ValidatableResponse validatableResponse = getListOfSearchEngineObjects()
                .then()
                .assertThat();

        List<String> listOfAllIdInResponse = new ArrayList<>();

        for (int i = 0; i < getNumberOfObjectsInResponse(validatableResponse); i++) {

            listOfAllIdInResponse
                    .add(String
                            .valueOf(getSearchEngineModelAsArray(validatableResponse)[i]
                                    .getId()));

        }

        return listOfAllIdInResponse;
    }

    @Override
    public List<String> getListOfAllProductSlugsInResponse() {

        ValidatableResponse validatableResponse = getListOfSearchEngineObjects()
                .then()
                .assertThat();

        List<String> listOfAllProductSlugsInResponse = new ArrayList<>();

        for (int i = 0; i < getNumberOfObjectsInResponse(validatableResponse); i++) {

            listOfAllProductSlugsInResponse
                    .add(String
                            .valueOf(getSearchEngineModelAsArray(validatableResponse)[i]
                                    .getProductSlug()));
        }

        return listOfAllProductSlugsInResponse;
    }

    @Override
    public Response getListOfSearchEngineObjects() {

        return new CreateSearchEngineRequest(
                SearchEnginesList.MORTGAGE_SEARCH_ENGINE.getSearchEngineName())
                .postToSearchEngineWithJSON(createJSONObjectForMortgageSearchEngine());
    }

    @Override
    public MortgageCreditSearchEngineResponseJsonModel getSearchEngineModel(ValidatableResponse validatableResponse) {

        return validatableResponse
                .extract()
                .as(MortgageCreditSearchEngineResponseJsonModel.class);
    }

    @Override
    public MortgageCreditSearchEngineResponseJsonModel[] getSearchEngineModelAsArray(
            ValidatableResponse validatableResponse
    ) {

        return validatableResponse
                .extract()
                .as(MortgageCreditSearchEngineResponseJsonModel[].class);
    }

    @Override
    public Response getSearchEngineObject(
            String key,
            String value
    ) {

        Response r = new CreateSearchEngineRequest(
                SearchEnginesList.MORTGAGE_SEARCH_ENGINE.getSearchEngineName())
                .getFromSearchEngineForObjectWithParamsFromJSON(
                        key,
                        value,
                        createJSONObjectForMortgageSearchEngine());

        r.then().log().all();

        return r;
    }

    private JSONObject createJSONObjectForMortgageSearchEngine( ) {

        return new JSONObject(
                new Gson()
                        .toJson(new MortgageCreditSearchEngineRequestDataFactory()
                                .getMortgageSearchEngineRequestJsonModel()));
    }


    private int getNumberOfObjectsInResponse(
            ValidatableResponse validatableResponse
    ) {

        int numberOfObjectsInResponse;

        try {
            numberOfObjectsInResponse = getSearchEngineModelAsArray(
                    validatableResponse)
                    .length;
        } catch (NullPointerException e ) {
            throw new IllegalArgumentException(
                    "Value provided in API_KEY_SEARCH_ENGINE is not assigned to any of the endpoints (serwis końcowy). Please use correct apiKey."
            );
        }

        return numberOfObjectsInResponse;
    }
}
