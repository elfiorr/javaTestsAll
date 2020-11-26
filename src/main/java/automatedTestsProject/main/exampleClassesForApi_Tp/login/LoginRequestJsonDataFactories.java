package automatedTestsProject.main.exampleClassesForApi_Tp.login;

import automatedTestsProject.main.exampleClassesForApi_Tp.partnerFactories.Partner;
import automatedTestsProject.main.exampleClassesForApi_Tp.partnerFactories.Password;

public class LoginRequestJsonDataFactories implements Password {

    public Partner getLoginRequestJsonWithoutPassword(
            String username
    ) {
        Partner loginRequestJsonModel = new Partner();

        loginRequestJsonModel.setUsername(username);
        loginRequestJsonModel.setPassword(correctPassword);

        return loginRequestJsonModel;
    }

    public Partner getLoginRequestJsonWithoutData(
            String username,
            String password
    ) {
        Partner loginRequestJsonModel = new Partner();

        loginRequestJsonModel.setUsername(username);
        loginRequestJsonModel.setPassword(password);

        return loginRequestJsonModel;
    }
}
