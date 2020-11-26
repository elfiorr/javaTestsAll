package packageWithAllTests.api.allegro.loginToApplication;

public class CorrectTokenInformationForLoginToApplicationTest extends LoginToApplicationTests {

    private static final int STATUS_CODE = 200;
    private static final String TOKEN_TYPE = "bearer";
    private static final boolean IS_ALLEGRO_API = true;
    private static final int EXPIRES_IN = 43199;

    public CorrectTokenInformationForLoginToApplicationTest() {
        super(
                STATUS_CODE,
                TOKEN_TYPE,
                IS_ALLEGRO_API,
                EXPIRES_IN
        );
    }
}
