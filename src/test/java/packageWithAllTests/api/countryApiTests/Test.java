package packageWithAllTests.api.countryApiTests;

public class Test extends AddCountriesStepdefs{


    private static final int STATUS_CODE = 200;
    private static final String NAME_OF_COUNTRY = "Poland";
    private static final String CAPITAL = "Warsaw";
    private static final int POPULATION = 39000000;
    private static final Long SURFACE = 312696L;
    private static final String OFFICIAL_LANGUAGE = "polish";
    private static final String TELEPHONE_CODE = "+48";

    public Test() {
        super(
                STATUS_CODE,
                NAME_OF_COUNTRY,
                CAPITAL,
                POPULATION,
                SURFACE,
                OFFICIAL_LANGUAGE,
                TELEPHONE_CODE
        );
    }
}
