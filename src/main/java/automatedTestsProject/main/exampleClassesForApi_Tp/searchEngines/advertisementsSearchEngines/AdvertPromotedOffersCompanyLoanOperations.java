package automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.advertisementsSearchEngines;

import automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.BasicSearchEngine;
import automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.BasicSearchEnginesList;
import automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.CreateSearchEngineRequest;
import automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.advertisementsSearchEngines.advertisementsResponseModel.AdvertisementsResponseJsonModel;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;

public class AdvertPromotedOffersCompanyLoanOperations extends BasicSearchEngine<AdvertisementsResponseJsonModel> {

    @Override
    public Response getListOfSearchEngineObjects() {
        return new CreateSearchEngineRequest(
                BasicSearchEnginesList
                        .ADVERT_PROMOTED_OFFERS_COMPANY_LOAN
                        .getSearchEngineName())
                .postToSearchEngine();
    }

    @Override
    public AdvertisementsResponseJsonModel getSearchEngineModel(
            ValidatableResponse validatableResponse
    ) {
        return validatableResponse
                .extract()
                .as(AdvertisementsResponseJsonModel.class);
    }

    @Override
    public AdvertisementsResponseJsonModel[] getSearchEngineModelAsArray(
            ValidatableResponse validatableResponse
    ) {
        return validatableResponse
                .extract()
                .as(AdvertisementsResponseJsonModel[].class);    }
}
