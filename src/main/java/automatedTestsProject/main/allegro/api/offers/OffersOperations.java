package automatedTestsProject.main.allegro.api.offers;

import automatedTestsProject.main.allegro.api.CreateAllegroRequest;
import automatedTestsProject.main.exampleClassesForApi_Tp.EndpointsFactory;
import com.jayway.restassured.response.ValidatableResponse;

public class OffersOperations extends CreateAllegroRequest {

    private ValidatableResponse validatableResponse;
    private String bearer;

    public OffersOperations(
            String categoryId,
            String bearer
    ) {

//        super(bearer);

        this.validatableResponse = getFromAllegroResponseWithOneParamAndBearerAuth(
                EndpointsFactory.ALLEGRO_OFFERS_LISTINING_CATEGORY,
                "category.id",
                categoryId,
                bearer)
                .then()
                .assertThat()
                .log()
                .all();
    }

    public ValidatableResponse getValidatableResponse() {

        return validatableResponse;
    }
}
