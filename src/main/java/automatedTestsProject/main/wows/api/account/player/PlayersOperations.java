package automatedTestsProject.main.wows.api.account.player;

import automatedTestsProject.main.exampleClassesForApi_Tp.EndpointsFactory;
import automatedTestsProject.main.wows.api.CreateWowsRequest;
import com.jayway.restassured.response.ValidatableResponse;

import java.util.HashMap;

public class PlayersOperations extends CreateWowsRequest {

    private ValidatableResponse validatableResponse;

    //Ponizszy konstruktor sie przyda do negatywnych przypadkow
    public PlayersOperations(
    ) {

        this.validatableResponse = getFromPublicResponseWithoutParam(
                EndpointsFactory.WOWS_EU_PLAYER_LIST)
                .then()
                .assertThat()
                .log()
                .all();
    }

    public PlayersOperations(HashMap<String, Object> mapOfParams) {

        this.validatableResponse = postFromPublicResponseWithOneParam(
                EndpointsFactory.WOWS_EU_PLAYER_LIST,
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
