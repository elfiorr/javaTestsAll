package packageWithAllTests.api.allegro.offers;

import automatedTestsProject.main.allegro.api.CreateAllegroRequest;
import automatedTestsProject.main.allegro.api.CreateAllegroRequest2;
import automatedTestsProject.main.allegro.api.loginToApplication.LoginToApplicationOperations;
import automatedTestsProject.main.allegro.api.offers.OffersOperations;
import com.jayway.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import packageWithAllTests.api.AbstractTest;

public class OffersListiningCategoryTests extends AbstractTest {


    private ValidatableResponse validatableResponse;
    private String bearer;
    private int statusCode;
    private String categoryId;
//    private String tokenType;
//    private boolean allegroApi;
//    private int expiresIn;
//
//    public OffersListiningCategoryTests(
//            String categoryId,
//            int statusCode,
//            String tokenType,
//            boolean allegroApi,
//            int expiresIn
//    ) {
//        this.categoryId = categoryId;
//        this.statusCode = statusCode;
//        this.tokenType = tokenType;
//        this.allegroApi = allegroApi;
//        this.expiresIn = expiresIn;
//
//        this.bearer = new LoginToApplicationOperations()
//                .getBearerToken();
//
//        this.validatableResponse = new OffersOperations(categoryId, bearer)
//                .getValidatableResponse();
//    }

    public OffersListiningCategoryTests(
            String categoryId,
            int statusCode
    ) {
        this.categoryId = categoryId;
        this.statusCode = statusCode;

        this.bearer = new LoginToApplicationOperations()
                .getBearerToken();

        this.validatableResponse = new OffersOperations(categoryId, bearer)
                .getValidatableResponse();
    }

    @BeforeEach
    public void setUp() {
        validatableResponse
                .log()
                .all();
    }

    @Test
    public void checkLoginToApplicationHttpStatusCode() {

        validatableResponse
                .statusCode(statusCode);
    }

//    @Test
//    public void checkLoginToApplicationHttpStatusCode() {
//
//        validatableResponse
//                .statusCode(statusCode);
//    }
}
