package automatedTestsProject.main.wows.api.warships;

import automatedTestsProject.main.wows.api.CreateWowsRequest;
import com.jayway.restassured.response.ValidatableResponse;

import java.util.HashMap;

import static automatedTestsProject.main.exampleClassesForApi_Tp.EndpointsFactory.WOWS_EU_SHIPS_INFO;

public class StatisticsOperations extends CreateWowsRequest {

    private ValidatableResponse validatableResponse;

    public StatisticsOperations(HashMap<String, Object> mapOfParams) {

        this.validatableResponse = postFromPublicResponseWithOneParam(
                WOWS_EU_SHIPS_INFO,
                mapOfParams)
                .then()
                .assertThat()
                .log()
                .all();
    }

    public ValidatableResponse getValidatableResponse() {

        return validatableResponse;
    }
}
