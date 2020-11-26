package automatedTestsProject.main.exampleClassesForApi_Tp.registration.register;

import automatedTestsProject.main.exampleClassesForApi_Tp.partnerFactories.Partner;

import java.util.List;

public class RegisterJsonDataFactories {

    private String email;
    private String password;
    private List<Integer> agreements;
    private String activationUrl;
    private String accountType;
    private int recommendedBy;

    public RegisterJsonDataFactories(
            String email,
            String password,
            List<Integer> agreements,
            String activationUrl,
            String accountType) {
        this.email = email;
        this.password = password;
        this.agreements = agreements;
        this.activationUrl = activationUrl;
        this.accountType = accountType;
    }

    public RegisterJsonDataFactories(
            String email,
            String password,
            List<Integer> agreements,
            String activationUrl,
            String accountType,
            int recommendedBy
    ) {
        this.email = email;
        this.password = password;
        this.agreements = agreements;
        this.activationUrl = activationUrl;
        this.accountType = accountType;
        this.recommendedBy = recommendedBy;
    }

    protected Partner getBasicRegisterRequestJsonModel(){

        Partner registerRequestJsonModel = new Partner();

        registerRequestJsonModel.setEmail(email);
        registerRequestJsonModel.setPassword(password);
        registerRequestJsonModel.setAccountType(accountType);
        registerRequestJsonModel.setAgreements(agreements);
        registerRequestJsonModel.setActivationUrl(activationUrl);

        return registerRequestJsonModel;
    }

    protected Partner getRecommendedRegisterRequestJsonModel(){

        Partner registerRequestJsonModel = getBasicRegisterRequestJsonModel();

        registerRequestJsonModel.setPartnerId(recommendedBy);

        return registerRequestJsonModel;
    }


}
