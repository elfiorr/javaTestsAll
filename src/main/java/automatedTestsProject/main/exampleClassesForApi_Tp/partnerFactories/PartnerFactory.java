package automatedTestsProject.main.exampleClassesForApi_Tp.partnerFactories;

import automatedTestsProject.main.core.generators.MailFormat;
import automatedTestsProject.main.core.generators.MailGenerator;
import automatedTestsProject.main.exampleClassesForApi_Tp.registration.register.AccountTypes;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.ArrayList;
import java.util.List;

public class PartnerFactory implements Password{

    public static final String FULL_NAME = "Kazimierz Przerwa";
    public static final String ZIP_CODE = "10-004";
    public static final String CITY = "Nowy Jork";
    public static final String ADDRESS = "Liberty Island 1984";
    public static final int SPECIALIZATION = 1;
    public static final String NIP = "5260251109";
    public static final String COUNTRY = "US";
    public static final String IBAN = "97114011080489009283774119";
    public static final String PESEL = "23062347966";
    public static final String KRS = "0000179679";
    public static final String REGON = "011166812";
    public static final String PHONE = "999000999";
    private static final String currentTime = DateTime.now().withZone(DateTimeZone.UTC).toString("yyyyMMddHHmmss");
    private static final String SUBDOMAIN = "subdomain"
            .concat(currentTime);
    private final String COMPANY_NAME = "companyName"
            .concat(currentTime);
    private final String FOREIGN_COMPANY_NAME = "foreignCompanyName"
            .concat(currentTime);
    private final String REGISTERED_NUMBER = "registerNumber"
            .concat(currentTime);
    private static final String DEFAULT_ACTIVATION_URL = "https://www.money2money.com.pl/activate/{token}";

    public Partner getDefaultPersonalPartner() {

        Partner personalPartner = getDefaultPartner();
        personalPartner.setEmail(new MailGenerator(MailFormat.DATE_TIME).getMail());
        personalPartner.setAccountType(AccountTypes.PERSONAL.getAccountType());
        personalPartner.setPesel(PESEL);

        return personalPartner;
    }

    public Partner getPersonalPartnerWithoutMail(
            String mail
    ) {

        Partner personalPartner = getDefaultPersonalPartner();
        personalPartner.setEmail(mail);

        return personalPartner;
    }

    public Partner getPersonalPartnerWithoutSubdomain(
            String mail
    ) {

        Partner personalPartner = getDefaultPersonalPartner();
        personalPartner.setSubdomain(SUBDOMAIN);

        return personalPartner;
    }

    public Partner getPersonalPartnerWithoutPassword(
            String password
    ) {

        Partner personalPartner = getDefaultPersonalPartner();
        personalPartner.setPassword(password);

        return personalPartner;
    }

    public Partner getDefaultCompanyPartner() {

        Partner companyPartner = getDefaultPartner();
        companyPartner.setEmail(new MailGenerator(MailFormat.DATE_TIME).getMail());
        companyPartner.setAccountType(AccountTypes.COMPANY.getAccountType());
        companyPartner.setCompanyName(COMPANY_NAME);
        companyPartner.setNip(NIP);
        companyPartner.setKrs(KRS);
        companyPartner.setRegon(REGON);

        return companyPartner;
    }

    public Partner getCompanyPartnerWithoutMail(
            String mail
    ) {

        Partner companyPartner = getDefaultCompanyPartner();
        companyPartner.setEmail(mail);

        return companyPartner;
    }

    public Partner getCompanyPartnerWithoutPassword(
            String password
    ) {

        Partner companyPartner = getDefaultCompanyPartner();
        companyPartner.setPassword(password);

        return companyPartner;
    }

    public Partner getDefaultForeignCompanyPartner() {

        Partner foreignCompanyPartner = getDefaultPartner();
        foreignCompanyPartner.setEmail(new MailGenerator(MailFormat.DATE_TIME).getMail());
        foreignCompanyPartner.setAccountType(AccountTypes.FOREIGN_COMPANY.getAccountType());
        foreignCompanyPartner.setCompanyName(FOREIGN_COMPANY_NAME);
        foreignCompanyPartner.setRegisteredNumber(REGISTERED_NUMBER);
        foreignCompanyPartner.setCountry(COUNTRY);

        return foreignCompanyPartner;
    }

    public Partner getForeignCompanyPartnerWithoutMail(
            String mail
    ) {

        Partner foreignCompanyPartner = getDefaultForeignCompanyPartner();
        foreignCompanyPartner.setEmail(mail);

        return foreignCompanyPartner;
    }

    public Partner getForeignCompanyPartnerWithoutPassword(
            String password
    ) {

        Partner foreignCompanyPartner = getDefaultForeignCompanyPartner();

        foreignCompanyPartner.setPassword(password);

        return foreignCompanyPartner;
    }


    private Partner getDefaultPartner() {

        Partner defaultPartner = new Partner();

        defaultPartner.setActivationUrl(DEFAULT_ACTIVATION_URL);
        defaultPartner.setPassword(correctPassword);
        defaultPartner.setFullName(FULL_NAME);
        defaultPartner.setAddress(ADDRESS);
        defaultPartner.setCity(CITY);
        defaultPartner.setZipCode(ZIP_CODE);
        defaultPartner.setSpecialization(SPECIALIZATION);
        defaultPartner.setPhoneNumber(PHONE);
        defaultPartner.setSubdomain(SUBDOMAIN);
        defaultPartner.setIban(IBAN);
        defaultPartner.setAgreements(defaultAgreements());
        defaultPartner.setPartnerId(getRecommendedBy());

        return defaultPartner;
    }


    private static final List<Integer> defaultAgreements() {

        List<Integer> defaultAgreements = new ArrayList<>();

        defaultAgreements.add(2);
        defaultAgreements.add(3);
        defaultAgreements.add(4);

        return defaultAgreements;
    }

    public static final int getRecommendedBy() {

        String RECOMMENDED_BY = System.getProperty("RECOMMENDED_BY");

        if (RECOMMENDED_BY == null) {
            return 33965;
        }
        return Integer.valueOf(RECOMMENDED_BY);
    }
}

