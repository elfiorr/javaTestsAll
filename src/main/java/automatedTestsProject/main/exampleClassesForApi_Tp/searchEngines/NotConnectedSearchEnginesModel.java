package automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines;

public enum NotConnectedSearchEnginesModel {

    //TOTALMONEY & FINANSOWYSUPERMARKET
    BUSINESS_ACCOUNT_SEARCH_ENGINE("BusinessAccountSearchEngine", "API_KEY_SEARCH_ENGINE_TM"),
    CAR_INSURANCE_SEARCH_ENGINE("CarInsuranceSearchEngine", "API_KEY_SEARCH_ENGINE_TM"),
    //CASH_CREDIT_SEARCH_ENGINE("CashCreditSearchEngine", "API_KEY_SEARCH_ENGINE_TM"),
    COMPANY_LOAN_SEARCH_ENGINE("CompanyLoanSearchEngine", "API_KEY_SEARCH_ENGINE_TM"),
    //CONSOLIDATION_CREDIT_SEARCH_ENGINE("ConsolidationCreditSearchEngine", "API_KEY_SEARCH_ENGINE_TM"),
    DEPOSIT_SEARCH_ENGINE("DepositSearchEngine", "API_KEY_SEARCH_ENGINE_TM"),
    //FAST_LOAN_SEARCH_ENGINE("FastLoanSearchEngine", "API_KEY_SEARCH_ENGINE_TM"),
    FINANCE_BROKER_SEARCH_ENGINE("FinanceBrokerSearchEngine", "API_KEY_SEARCH_ENGINE_TM"),
    INVESTMENT_FUND_SEARCH_ENGINE("InvestmentFundSearchEngine", "API_KEY_SEARCH_ENGINE_TM"),
    LONG_TERM_LEASE_SEARCH_ENGINE("LongTermLeaseSearchEngine", "API_KEY_SEARCH_ENGINE_TM"),
    MORTGAGE_CREDIT_SEARCH_ENGINE("MortgageCreditSearchEngine", "API_KEY_SEARCH_ENGINE_TM"),
    NON_FINANCIAL_PRODUCT_SEARCH_ENGINE("NonFinancialProductSearchEngine", "API_KEY_SEARCH_ENGINE_TM"),
    ONLINE_CURRENCY_EXCHANGE_SEARCH_ENGINE("OnlineCurrencyExchangeSearchEngine", "API_KEY_SEARCH_ENGINE_TM"),
    //ONLINE_LOAN_SEARCH_ENGINE("OnlineLoanSearchEngine", "API_KEY_SEARCH_ENGINE_TM"),
    OTHER_INSURANCE_SEARCH_ENGINE("OtherInsuranceSearchEngine", "API_KEY_SEARCH_ENGINE_TM"),
    PENSION_SEARCH_ENGINE("PensionSearchEngine", "API_KEY_SEARCH_ENGINE_TM"),
    PERSONAL_SAVING_ACCOUNT_SEARCH_ENGINE("PersonalSavingAccountSearchEngine", "API_KEY_SEARCH_ENGINE_TM"),
    START_CREDIT_SEARCH_ENGINE("StartCreditSearchEngine", "API_KEY_SEARCH_ENGINE_TM"),

    //M2M
    M2M_CONTEST_SEARCH_ENGINE("M2MContestSearchEngine", "API_KEY_SEARCH_ENGINE_M2M"),
    M2M_FAQ_SEARCH_ENGINE("M2MFaqSearchEngine", "API_KEY_SEARCH_ENGINE_M2M"),
    M2M_FILES_SEARCH_ENGINE("M2MFilesSearchEngine", "API_KEY_SEARCH_ENGINE_M2M"),
    M2M_VIDEO_SEARCH_ENGINE("M2MVideoSearchEngine", "API_KEY_SEARCH_ENGINE_M2M");


    private String searchEngine;
    private String apiKey;

    NotConnectedSearchEnginesModel(
            String searchEngineValue,
            String apiKeyValue) {
        this.searchEngine = searchEngineValue;
        this.apiKey = apiKeyValue;
    }

    public String getSearchEngineName() {
        return searchEngine;
    }

    public String getSearchEngineApiKey() {
//    return apiKey;

    return "ZNnqJmepWUzwbMt6HQzkxZrNLj5gFrjE";
//        return "2Lfh34BBqkLjRztp5S55pEcX6HkcJ9y2RudDhQwB";
    }
}
