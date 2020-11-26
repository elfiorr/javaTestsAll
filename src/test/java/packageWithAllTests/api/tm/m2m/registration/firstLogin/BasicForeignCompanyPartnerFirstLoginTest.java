package packageWithAllTests.api.tm.m2m.registration.firstLogin;

import automatedTestsProject.main.exampleClassesForApi_Tp.partnerFactories.PartnerFactory;
import automatedTestsProject.main.exampleClassesForApi_Tp.registration.register.AccountTypes;
import automatedTestsProject.main.exampleClassesForApi_Tp.registration.register.RegisterTypes;

import java.io.FileNotFoundException;

public class BasicForeignCompanyPartnerFirstLoginTest extends FirstLoginTests {

    public BasicForeignCompanyPartnerFirstLoginTest(
    ) throws FileNotFoundException {
        super(
                RegisterTypes.BASIC,
                new PartnerFactory()
                        .getDefaultForeignCompanyPartner(),
                AccountTypes.FOREIGN_COMPANY);

    }
}
