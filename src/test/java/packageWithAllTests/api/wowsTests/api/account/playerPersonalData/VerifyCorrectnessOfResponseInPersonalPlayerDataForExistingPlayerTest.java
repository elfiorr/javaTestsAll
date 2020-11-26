package packageWithAllTests.api.wowsTests.api.account.playerPersonalData;

import java.util.HashMap;

public class VerifyCorrectnessOfResponseInPersonalPlayerDataForExistingPlayerTest extends PlayerPersonalDataTests {

    private static final int STATUS_CODE = 200;
    private static final String STATUS_IN_BODY = "ok";
    private static final int COUNT_IN_BODY = 1;
    private static final String USER_NAME = "elfiorr";
    private static final boolean IS_PROFILE_HIDDEN = false;

    private static final HashMap<String, Object> map() {

        HashMap<String, Object> mapOfDates = new HashMap<>();

        mapOfDates.put("account_id", "501662117");

        return mapOfDates;
    }

    public VerifyCorrectnessOfResponseInPersonalPlayerDataForExistingPlayerTest() {
        super(
                map(),
                STATUS_CODE,
                STATUS_IN_BODY,
                COUNT_IN_BODY,
                USER_NAME,
                IS_PROFILE_HIDDEN);
    }
}
