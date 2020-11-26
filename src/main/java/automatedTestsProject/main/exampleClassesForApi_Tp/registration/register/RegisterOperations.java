package automatedTestsProject.main.exampleClassesForApi_Tp.registration.register;

import automatedTestsProject.main.exampleClassesForApi_Tp.CreatePublicM2mRequest;
import automatedTestsProject.main.exampleClassesForApi_Tp.EndpointsFactory;
import automatedTestsProject.main.exampleClassesForApi_Tp.partnerFactories.Partner;
import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.util.List;

public class RegisterOperations extends CreatePublicM2mRequest {

    private RegisterTypes registerType;
    private String email;
    private String password;
    private List<Integer> agreements;
    private String activationUrl;
    private String accountType;
    private int recommendedBy;

    public RegisterOperations(
            RegisterTypes registerTypeValue,
            Partner partner,
            AccountTypes accountType
    ) {
        this.registerType = registerTypeValue;
        this.email = partner.getEmail();
        this.password = partner.getPassword();
        this.agreements = partner.getAgreements();
        this.activationUrl = partner.getActivationUrl();
        this.accountType = accountType.getAccountType();
        this.recommendedBy = partner.getPartnerId();
    }

    public Response registerNewUser() throws FileNotFoundException {

        return postJsonToPublicEndpoint(
                EndpointsFactory.M_2_M_REGISTER,
                createRegisterJSONObject());
    }


    private JSONObject createRegisterJSONObject(){

        switch (registerType) {

            case BASIC:
                return new JSONObject(
                        new Gson().toJson(
                                new RegisterJsonDataFactories(
                                        email,
                                        password,
                                        agreements,
                                        activationUrl,
                                        accountType)
                        .getBasicRegisterRequestJsonModel())
                );

            case RECOMMENDED:
                return new JSONObject(
                        new Gson().toJson(
                                new RegisterJsonDataFactories(
                                        email,
                                        password,
                                        agreements,
                                        activationUrl,
                                        accountType,
                                        recommendedBy)
                                        .getRecommendedRegisterRequestJsonModel()));

            case FACEBOOK:
                throw new AssertionError("Waiting for: https://jira.grupawp.pl/browse/SPN-2360");

            default:
                throw new IllegalArgumentException();

        }
    }

}
