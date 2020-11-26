package packageWithAllTests.api.wowsTests.api.account.ships;

import java.util.HashMap;

public class VerifyCorrectnessOfResponseInPlayerShipsStatisticsForExistingPlayerTest extends PlayerStatisticsShipsTests {

    private static final int STATUS_CODE = 200;
    private static final String STATUS_IN_BODY = "ok";
    private static final int COUNT_IN_BODY = 1;
    private static final Object IS_PROFILE_HIDDEN = null;

    private static final HashMap<String, Object> map() {

        HashMap<String, Object> mapOfDates = new HashMap<>();

        mapOfDates.put("account_id", "501662117");

        return mapOfDates;
    }

    public VerifyCorrectnessOfResponseInPlayerShipsStatisticsForExistingPlayerTest() {
        super(
                map(),
                STATUS_CODE,
                STATUS_IN_BODY,
                COUNT_IN_BODY,
                IS_PROFILE_HIDDEN
        );
    }
}
