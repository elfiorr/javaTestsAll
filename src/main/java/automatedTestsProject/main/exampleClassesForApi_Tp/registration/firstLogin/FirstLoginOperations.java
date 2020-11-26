package automatedTestsProject.main.exampleClassesForApi_Tp.registration.firstLogin;

import automatedTestsProject.main.exampleClassesForApi_Tp.CreateUserM2mRequest;
import automatedTestsProject.main.exampleClassesForApi_Tp.EndpointsFactory;
import automatedTestsProject.main.exampleClassesForApi_Tp.partnerFactories.Partner;
import automatedTestsProject.main.exampleClassesForApi_Tp.registration.register.AccountTypes;
import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import org.json.JSONObject;

import java.io.FileNotFoundException;

public class FirstLoginOperations extends CreateUserM2mRequest {

    private Partner partner;
    private AccountTypes accountType;

    public FirstLoginOperations(
            String bearerValue,
            Partner partner,
            AccountTypes accountType
    ) {
        super(bearerValue);
        this.partner = partner;
        this.accountType = accountType;
    }

    public Response getResponseFromFirstLogin() throws FileNotFoundException {

        return putJsonToUserEndpoint(
                EndpointsFactory.M_2_M_FIRST_LOGIN,
                createFirstLoginJSONObject());
    }


    private JSONObject createFirstLoginJSONObject() {

        switch (accountType) {

            case PERSONAL:
                return new  JSONObject(new Gson()
                        .toJson(new FirstLoginRequestJsonDataFactories(partner)
                                .getFirstLoginForPersonalPartnerRequestJsonModel()));

            case COMPANY:
                return new  JSONObject(new Gson()
                        .toJson(new FirstLoginRequestJsonDataFactories(partner)
                                .getFirstLoginForCompanyPartnerRequestJsonModel()));

            case FOREIGN_COMPANY:
                return new  JSONObject(new Gson()
                        .toJson(new FirstLoginRequestJsonDataFactories(partner)
                                .getFirstLoginForForeignCompanyPartnerRequestJsonModel()));


            default:
                throw new IllegalArgumentException();
        }
    }
}
