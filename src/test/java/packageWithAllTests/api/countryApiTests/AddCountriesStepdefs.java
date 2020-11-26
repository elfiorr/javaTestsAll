package packageWithAllTests.api.countryApiTests;

import automatedTestsProject.main.countryApi.CountryOperations;
import com.jayway.restassured.response.ValidatableResponse;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddCountriesStepdefs {

    private ValidatableResponse validatableResponse;
    private int statusCode;
    private String nameOfCountry;
    private String capital;
    private int population;
    private Long surface;
    private String officialLanguage;
    private String telephoneCode;

    public AddCountriesStepdefs(
            int statusCode,
            String nameOfCountry,
            String capital,
            int population,
            Long surface,
            String officialLanguage,
            String telephoneCode

    ) {

        this.validatableResponse = new CountryOperations(
                nameOfCountry,
                capital,
                population,
                surface,
                officialLanguage,
                telephoneCode
        )
                .getValidatableResponse();

        this.statusCode = statusCode;
    }

    @BeforeEach
    public void setUp() {

        validatableResponse
                .log()
                .all();
    }

    @Test
    public void x() {

        validatableResponse
                .statusCode(statusCode);
    }
}
