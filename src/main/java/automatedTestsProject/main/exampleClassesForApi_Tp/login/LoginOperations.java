package automatedTestsProject.main.exampleClassesForApi_Tp.login;

import automatedTestsProject.main.exampleClassesForApi_Tp.CreatePublicM2mRequest;
import automatedTestsProject.main.exampleClassesForApi_Tp.EndpointsFactory;
import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import org.json.JSONObject;

import java.io.FileNotFoundException;

public class LoginOperations extends CreatePublicM2mRequest {

    private Response responseFromLoginEndpoint;

    public LoginOperations(
            String username,
            String password
    ) {
        try {
            this.responseFromLoginEndpoint = postJsonToPublicEndpoint(
                    EndpointsFactory.M_2_M_LOGIN,
                    new JSONObject(
                            new Gson().toJson(
                                    new LoginRequestJsonDataFactories()
                                            .getLoginRequestJsonWithoutData(
                                                    username,
                                                    password))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public LoginOperations(
            String username
    ) {
        try {
            this.responseFromLoginEndpoint = postJsonToPublicEndpoint(
                    EndpointsFactory.M_2_M_LOGIN,
                    new JSONObject(
                            new Gson().toJson(
                                    new LoginRequestJsonDataFactories()
                                            .getLoginRequestJsonWithoutPassword(
                                                    username))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Logs user
     *
     * @return Response from login endpoint
     * @throws FileNotFoundException
     */
    public Response getUserLoginResponse() {

        return responseFromLoginEndpoint;

    }

    /**
     * Gets user token to further use in authorization header in user endpoints
     *
     * @return String with user token
     * @throws FileNotFoundException
     */
    public String getUserBearer() {

        return responseFromLoginEndpoint
                .then()
                .extract()
                .as(LoginResponseJsonModel.class)
                .getToken();
    }
}
