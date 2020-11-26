package automatedTestsProject.main.wows.api.account.playerPersonalData;

import automatedTestsProject.main.exampleClassesForApi_Tp.EndpointsFactory;
import automatedTestsProject.main.wows.api.CreateWowsRequest;
import com.jayway.restassured.response.ValidatableResponse;

import java.util.HashMap;

import static automatedTestsProject.main.core.apiHelpers.ParametersFactory.WOWS_EU_APPLICATION_ID_FIRST;

public class PlayerPersonalDataOperations extends CreateWowsRequest {

    private ValidatableResponse validatableResponse;

    public PlayerPersonalDataOperations(HashMap<String, Object> mapOfParams) {

        this.validatableResponse = postFromPublicResponseWithOneParam(
                EndpointsFactory.WOWS_EU_PLAYER_INFO,
                mapOfParams
        )
                .then()
                .assertThat()
                .log()
                .all();
    }

    public ValidatableResponse getValidatableResponse() {

        return validatableResponse;
    }
}
