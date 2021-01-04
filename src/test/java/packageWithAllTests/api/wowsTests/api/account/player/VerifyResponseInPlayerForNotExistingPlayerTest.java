package packageWithAllTests.api.wowsTests.api.account.player;

import org.junit.jupiter.api.Tag;

import java.util.HashMap;

import static packageWithAllTests.api.TestParametersFactory.API_WOWS;

@Tag(API_WOWS)
public class VerifyResponseInPlayerForNotExistingPlayerTest extends PlayerTests {

    private static final int STATUS_CODE = 200;
    private static final String STATUS_IN_BODY = "ok";
    private static final int COUNT_IN_BODY = 0;

    private static final HashMap<String, Object> map() {

        HashMap<String, Object> mapOfDates = new HashMap<>();

        mapOfDates.put("search", "elfiorr2");

        return mapOfDates;
    }

    public VerifyResponseInPlayerForNotExistingPlayerTest() {
        super(
                map(),
                STATUS_CODE,
                STATUS_IN_BODY,
                COUNT_IN_BODY
        );
    }
}
