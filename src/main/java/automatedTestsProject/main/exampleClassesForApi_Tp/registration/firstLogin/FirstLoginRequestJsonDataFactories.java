package automatedTestsProject.main.exampleClassesForApi_Tp.registration.firstLogin;

import automatedTestsProject.main.exampleClassesForApi_Tp.partnerFactories.Partner;

public class FirstLoginRequestJsonDataFactories {

    private Partner partner;

    public FirstLoginRequestJsonDataFactories(
            Partner partner
    ) {
        this.partner = partner;
    }

    public Partner getFirstLoginForPersonalPartnerRequestJsonModel() {

        Partner firstLoginForPersonalPartnerRequestJsonModel = getDefaultFirstLoginRequestJsonModel();

        return firstLoginForPersonalPartnerRequestJsonModel;
    }

    public Partner getFirstLoginForCompanyPartnerRequestJsonModel() {

        Partner firstLoginForCompanyPartnerRequestJsonModel = getDefaultFirstLoginRequestJsonModel();
        firstLoginForCompanyPartnerRequestJsonModel.setCompanyName(partner.getCompanyName());
        firstLoginForCompanyPartnerRequestJsonModel.setNip(partner.getNip());

        return firstLoginForCompanyPartnerRequestJsonModel;
    }

    public Partner getFirstLoginForForeignCompanyPartnerRequestJsonModel() {

        Partner firstLoginForForeignCompanyPartnerRequestJsonModel = getDefaultFirstLoginRequestJsonModel();
        firstLoginForForeignCompanyPartnerRequestJsonModel.setCompanyName(partner.getCompanyName());
        firstLoginForForeignCompanyPartnerRequestJsonModel.setRegisteredNumber(partner.getRegisteredNumber());
        firstLoginForForeignCompanyPartnerRequestJsonModel.setCountry(partner.getCountry());

        return firstLoginForForeignCompanyPartnerRequestJsonModel;
    }

    private Partner getDefaultFirstLoginRequestJsonModel() {

        Partner defaultFirstLoginRequestJsonModel = new Partner();
        defaultFirstLoginRequestJsonModel.setFullName(partner.getFullName());
        defaultFirstLoginRequestJsonModel.setAddress(partner.getAddress());
        defaultFirstLoginRequestJsonModel.setZipCode(partner.getZipCode());
        defaultFirstLoginRequestJsonModel.setCity(partner.getCity());
        defaultFirstLoginRequestJsonModel.setPhoneNumber(partner.getPhoneNumber());
        defaultFirstLoginRequestJsonModel.setSpecialization(partner.getSpecialization());
        defaultFirstLoginRequestJsonModel.setSubdomain(partner.getSubdomain());

        return defaultFirstLoginRequestJsonModel;
    }
}
