package packageWithAllTests.api.wowsTests.api.account.player;

import automatedTestsProject.main.wows.api.account.player.PlayersOperations;
import automatedTestsProject.main.wows.api.account.player.playerResponseWithApplicationId.PlayerResponseJsonModel;
import com.jayway.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import packageWithAllTests.api.AbstractTest;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTests extends AbstractTest {

    private ValidatableResponse validatableResponse;
    private int statusCode;
    private String responseStatus;
    private int responseCount;
    private String accountId;
    private HashMap<String, Object> mapOfParams;


    //Dodac negatywne przypadki
    public PlayerTests(
            HashMap<String, Object> mapOfParams,
            int statusCode,
            String responseStatus,
            int responseCount
    ) {
        super();

        this.validatableResponse = new PlayersOperations(mapOfParams)
                .getValidatableResponse();

        this.statusCode = statusCode;
        this.responseStatus = responseStatus;
        this.responseCount = responseCount;
        this.mapOfParams = mapOfParams;
    }

    public PlayerTests(
            HashMap<String, Object> mapOfParams,
            int statusCode,
            String responseStatus,
            int responseCount,
            String accountId
    ) {
        super();

        this.validatableResponse = new PlayersOperations(mapOfParams)
                .getValidatableResponse();

        this.statusCode = statusCode;
        this.responseStatus = responseStatus;
        this.responseCount = responseCount;
        this.accountId = accountId;
    }

    @BeforeEach
    public void setUp() {
        validatableResponse
                .log()
                .all();
    }

    @Test
    public void checkAccountHttpStatusCode() {
        validatableResponse
                .statusCode(statusCode);
    }

    @Test
    public void checkAccountStructure() {

        getAccountsResponseJsonModel();
    }

    @Test
    public void checkStatusInResponseBodyTest() {

        assertEquals(
                responseStatus,
                getAccountsResponseJsonModel()
                        .getStatus(),
                NOT_CORRECT_RESPONSE);
    }

    @Test
    public void checkCountInResponseBodyTest() {

        assertEquals(
                responseCount,
                getAccountsResponseJsonModel()
                        .getMeta()
                        .getCount(),
                NOT_CORRECT_RESPONSE);
    }

    @Test
    public void checkNicknameInResponseBodyTest() {

        if (accountId != null) {

            assertEquals(
                    "elfiorr",
                    getAccountsResponseJsonModel()
                            .getData()
                            .get(0)
                            .getNickname(),
                    NOT_CORRECT_RESPONSE);
        }

    }

    @Test
    public void checkAccountIdInResponseBodyTest() {

        if (accountId != null) {
            assertEquals(
                    accountId,
                    getAccountsResponseJsonModel()
                            .getData()
                            .get(0)
                            .getAccountId()
                            .toString(),
                    NOT_CORRECT_RESPONSE);
        }
    }

    private PlayerResponseJsonModel getAccountsResponseJsonModel() {

        return validatableResponse
                .extract()
                .as(PlayerResponseJsonModel.class);
    }
}
