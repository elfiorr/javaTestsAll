package automatedTestsProject.main.countryApi;

import com.google.gson.Gson;
import com.jayway.restassured.response.ValidatableResponse;
import org.json.JSONObject;

import static springProject.springBoot1.EndpointFactory.ADD_NEW;
import static springProject.springBoot1.EndpointFactory.ALL;

public class CountryOperations extends CreateCountryRequest {

    private ValidatableResponse validatableResponse;
    private JSONObject countryJson;

    public CountryOperations() {

        this.validatableResponse = getFromLocalResponseWithoutParam(
                ALL)
                .then()
                .assertThat()
                .log()
                .all();
    }

    public CountryOperations(
            String nameOfCountry,
            String capitol,
            int population,
            Long surface,
            String officialLanguage,
            String telephoneCode) {

        this.countryJson = new JSONObject(
                new Gson().toJson(
                        new CountryRequestJsonDataFactory(
                                nameOfCountry,
                                capitol,
                                population,
                                surface,
                                officialLanguage,
                                telephoneCode
                        ).addCountryRequestJsonModel()));

        this.validatableResponse = postFromLocalResponseWithoutParamAndWithJson(
                ADD_NEW, countryJson)
                .then()
                .assertThat()
                .log()
                .all();
    }

    public ValidatableResponse getValidatableResponse() {

        return validatableResponse;
    }
}
