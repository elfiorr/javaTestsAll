package automatedTestsProject.main.exampleClassesForApi_Tp.registration.activate;

import automatedTestsProject.main.core.apiHelpers.ParametersFactory;
import automatedTestsProject.main.exampleClassesForApi_Tp.CreatePublicM2mRequest;
import automatedTestsProject.main.exampleClassesForApi_Tp.EndpointsFactory;
import automatedTestsProject.main.exampleClassesForApi_Tp.login.LoginResponseJsonModel;
import com.jayway.restassured.response.Response;

import java.io.FileNotFoundException;

public class ActivateOperations extends CreatePublicM2mRequest {

    private String partnerMail;

    public ActivateOperations(
            String partnerMail
    ) {
        this.partnerMail = partnerMail;
    }

    /**
     * Gets partner registration token from database field Activation_token base on user email
     *
     * @return Response with activation token
     * @throws FileNotFoundException
     */
    private Response getPartnerRegistrationTokenResponse() throws FileNotFoundException {

        return getFromPublicDevResponse(EndpointsFactory
                        .m2MGetPartnerRegistrationTokenEndpoint(partnerMail));

    }

    /**
     * Converts Response form getPartnerRegistrationTokenResponse to String without white sights
     *
     * @return token as String
     * @throws FileNotFoundException
     */
    private String getPartnerRegistrationTokenValue() throws FileNotFoundException {

        return getPartnerRegistrationTokenResponse()
                .prettyPrint()
                .replaceAll("\"", "");
    }

    /**
     * Send activation token as form data to activation endpoint and activates user
     *
     * @return Response form activation endpoint
     * @throws FileNotFoundException
     */
    public Response getRegisterActivateResponse() throws FileNotFoundException {

        return postFormDataToPublicResponse(
                        EndpointsFactory.M_2_M_ACTIVATE,
                        ParametersFactory.TOKEN,
                        getPartnerRegistrationTokenValue());
    }

    /**
     * Extract user token from response from activation endpoint
     *
     * @param activateResponse user token
     * @return
     */
    public String getBearerTokenAfterActivate(
            Response activateResponse
    ) {

        return activateResponse
                .then()
                .extract()
                .as(LoginResponseJsonModel.class)
                .getToken();
    }
}
