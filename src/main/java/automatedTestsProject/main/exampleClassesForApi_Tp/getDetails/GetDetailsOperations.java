package automatedTestsProject.main.exampleClassesForApi_Tp.getDetails;

import automatedTestsProject.main.exampleClassesForApi_Tp.CreateUserM2mRequest;
import automatedTestsProject.main.exampleClassesForApi_Tp.EndpointsFactory;
import com.jayway.restassured.response.Response;

import java.io.FileNotFoundException;

public class GetDetailsOperations extends CreateUserM2mRequest {

    private Response userDetailsResponse;

    public GetDetailsOperations(String bearerValue) {
        super(bearerValue);

        try {
            this.userDetailsResponse = getFromUserEndpoint(
                    //endpoint zostal przykladowy
                    EndpointsFactory.M_2_M_LOGIN);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Response getDetails() {

        return userDetailsResponse;

    }

}
