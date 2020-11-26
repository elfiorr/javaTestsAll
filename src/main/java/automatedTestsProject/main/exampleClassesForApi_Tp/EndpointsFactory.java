package automatedTestsProject.main.exampleClassesForApi_Tp;

import automatedTestsProject.main.core.dataMappingConfig.DataConfig;
import automatedTestsProject.main.core.dataMappingConfig.ResourcesPathFactory;

import java.io.FileNotFoundException;

public class EndpointsFactory {

    private static final String TP_API_DEV_URL = "/api/dev";
    private static final String M_2_M_URL_INDEX_PREFIX = "/api/affiliation";
    public static final String M_2_M_REGISTER = "/public/register";
    public static final String M_2_M_GET_PARTNER_REGISTRATION_TOKEN = "/partner-registration-token";
    public static final String M_2_M_ACTIVATE = "/public/register/activate";
    public static final String M_2_M_LOGIN = "/login";
    public static final String M_2_M_FIRST_LOGIN = "/firstLogin/save-data";
    public static final String M_2_M_EARNINGS_BILL = "/earnings/bills";
    public static final String M_2_M_EARNINGS_REPORT = "/report";
    public static final String M_2_M_BANK_ACCOUNT_BANK_NAME = "/public/bankAccount";
    public static final String M_2_M_VALIDATE_SUBDOMAIN = "/public/validate/subdomain";
    public static final String WOWS_EU_PLAYER_LIST = "/account/list/";
    public static final String WOWS_EU_PLAYER_INFO = "/account/info/";
    public static final String WOWS_EU_SHIPS_INFO = "/ships/stats/";
    public static final String ALLEGRO_OAUTH_TOKEN = "/auth/oauth/token";
    public static final String ALLEGRO_OFFERS_LISTINING_CATEGORY = "/offers/listing";

    public static final String tpUrlEndpoint() throws FileNotFoundException {

        return new StringBuilder()
                .append(DataConfig.getConnectionData(
                        ResourcesPathFactory.PATH_TO_URL,
                        "tp_url"))
                .toString();
    }

    public static final String m2MApiUrlEndpoint() throws FileNotFoundException {

        return new StringBuilder()
                .append(tpUrlEndpoint())
                .append(M_2_M_URL_INDEX_PREFIX)
                .toString();
    }

    public static final String devApiUrlEndpoint() throws FileNotFoundException {

        return new StringBuilder()
                .append(tpUrlEndpoint())
                .append(TP_API_DEV_URL)
                .toString();
    }

    public static final String m2MGetPartnerRegistrationTokenEndpoint(
            String partnerMail
    ) {

        return new StringBuilder()
                .append(M_2_M_GET_PARTNER_REGISTRATION_TOKEN)
                .append("/")
                .append(partnerMail)
                .toString();
    }

    public static final String m2MEarningsBillApiUrlEndpoint(
            String year,
            String number
    ) {

        return new StringBuilder()
                .append(M_2_M_EARNINGS_BILL)
                .append("/")
                .append(year)
                .append("/")
                .append(number)
                .toString();
    }

    public static final String m2MEarningsBillReportApiUrlEndpoint(
            String year,
            String number
    ) {

        return new StringBuilder()
                .append(m2MEarningsBillApiUrlEndpoint(
                        year,
                        number))
                .append(M_2_M_EARNINGS_REPORT)
                .toString();
    }

    public static final String m2mBankAccountBankNameUrlEndpoint(
            String accountNumber
    ) {

        return new StringBuilder()
                .append(M_2_M_BANK_ACCOUNT_BANK_NAME)
                .append("/")
                .append(accountNumber)
                .append("/details")
                .toString();
    }

    public static final String m2mValidateSubdomainUrlEndpoint(
            String subdomain
    ) {

        return new StringBuilder()
                .append(M_2_M_VALIDATE_SUBDOMAIN)
                .append("/")
                .append(subdomain)
                .toString();
    }
}
