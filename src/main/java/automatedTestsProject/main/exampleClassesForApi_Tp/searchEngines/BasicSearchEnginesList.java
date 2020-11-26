package automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines;

import automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.advertisementsSearchEngines.AdvertPromotedOffersCompanyLoanOperations;

public enum BasicSearchEnginesList {

    ADVERT_PROMOTED_OFFERS_COMPANY_LOAN(
            "AdvertPromotedOffersCompanyLoan",
            new AdvertPromotedOffersCompanyLoanOperations());

    private String searchEngineName;
    private BasicSearchEngine searchEngine;

    BasicSearchEnginesList(
            String searchEngineValue,
            BasicSearchEngine searchEngine
    ) {
        this.searchEngineName = searchEngineValue;
        this.searchEngine = searchEngine;
    }

    public String getSearchEngineName() {
        return searchEngineName;
    }

    public BasicSearchEngine getSearchEngine() {
        return searchEngine;
    }
}
