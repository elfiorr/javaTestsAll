package automatedTestsProject.main.exampleClassesForApi_Tp.registration.validateSubdomain;

import automatedTestsProject.main.exampleClassesForApi_Tp.CreatePublicM2mRequest;
import automatedTestsProject.main.exampleClassesForApi_Tp.EndpointsFactory;
import com.jayway.restassured.response.Response;

import java.io.FileNotFoundException;

public class ValidateSubdomainOperations extends CreatePublicM2mRequest {

    private Response response;

    public ValidateSubdomainOperations(
            String subdomain
    ) {

        try {
            this.response = getFromPublicResponse(
                    EndpointsFactory.m2mValidateSubdomainUrlEndpoint(subdomain));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Response getValidateSubdomainResponse(){

        return response;
    }
}
