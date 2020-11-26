package packageWithAllTests.api.wowsTests.api.account.playerPersonalData;

import automatedTestsProject.main.wows.api.account.playerPersonalData.PlayerPersonalDataOperations;
import automatedTestsProject.main.wows.api.account.playerPersonalData.playerPersonalDataResponse.PlayerPersonalDataResponseJsonModel;
import com.jayway.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import packageWithAllTests.api.AbstractTest;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerPersonalDataTests extends AbstractTest {

    private ValidatableResponse validatableResponse;
    private int statusCode;
    private String responseStatus;
    private int responseCount;
    private String nickname;
    private boolean hidden;
    private HashMap<String, Object> mapOfParams;

    public PlayerPersonalDataTests(
            HashMap<String, Object> mapOfParams,
            int statusCode,
            String responseStatus,
            int responseCount,
            String nickname,
            boolean hidden
    ) {
        super();

        this.validatableResponse = new PlayerPersonalDataOperations(mapOfParams)
                .getValidatableResponse();

        this.statusCode = statusCode;
        this.responseStatus = responseStatus;
        this.responseCount = responseCount;
        this.nickname = nickname;
        this.hidden = hidden;
        this.mapOfParams = mapOfParams;

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

        assertEquals(
                nickname,
                getAccountsResponseJsonModel()
                        .getData()
                        .get501662117()
                        .getNickname(),
                NOT_CORRECT_RESPONSE);
    }

    @Test
    public void checkAccountIdInResponseBodyTest() {

        assertEquals(
                Long.valueOf(501662117),
                getAccountsResponseJsonModel()
                        .getData()
                        .get501662117()
                        .getAccountId(),
                NOT_CORRECT_RESPONSE);
    }

    @Test
    public void checkIsHiddenProfileInResponseBodyTest() {

        assertEquals(
                hidden,
                getAccountsResponseJsonModel()
                        .getData()
                        .get501662117()
                        .getHiddenProfile(),
                NOT_CORRECT_RESPONSE);
    }

    private PlayerPersonalDataResponseJsonModel getAccountsResponseJsonModel() {

        return validatableResponse
                .extract()
                .as(PlayerPersonalDataResponseJsonModel.class);
    }
}
