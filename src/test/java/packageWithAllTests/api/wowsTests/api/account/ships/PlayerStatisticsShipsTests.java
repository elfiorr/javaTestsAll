package packageWithAllTests.api.wowsTests.api.account.ships;

import automatedTestsProject.main.wows.api.warships.StatisticsOperations;
import automatedTestsProject.main.wows.api.warships.statistics.statisticsResponse.StatisticsResponseJsonModel;
import com.jayway.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import packageWithAllTests.api.AbstractTest;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerStatisticsShipsTests extends AbstractTest {

    private ValidatableResponse validatableResponse;
    private int statusCode;
    private String responseStatus;
    private int responseCount;
    private Object hidden;
    private HashMap<String, Object> mapOfParams;

    public PlayerStatisticsShipsTests(
            HashMap<String, Object> mapOfParams,
            int statusCode,
            String responseStatus,
            int responseCount,
            Object hidden
    ) {
        super();

        this.validatableResponse = new StatisticsOperations(mapOfParams)
                .getValidatableResponse();

        this.statusCode = statusCode;
        this.responseStatus = responseStatus;
        this.responseCount = responseCount;
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
    public void checkIsHiddenProfileInResponseBodyTest() {

        assertEquals(
                hidden,
                getAccountsResponseJsonModel()
                        .getMeta()
                        .getHidden(),
                NOT_CORRECT_RESPONSE);
    }

    private StatisticsResponseJsonModel getAccountsResponseJsonModel() {

        return validatableResponse
                .extract()
                .as(StatisticsResponseJsonModel.class);
    }
}
