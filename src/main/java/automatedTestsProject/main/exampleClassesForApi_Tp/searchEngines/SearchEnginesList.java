package automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines;

import automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.searchEnginesJsonsModels.mortgageCreditSearchEngine.MortgageCreditSearchEngineOperations;

public enum SearchEnginesList {

    MORTGAGE_SEARCH_ENGINE("MortgageCreditSearchEngine",
            new MortgageCreditSearchEngineOperations());

    private String searchEngineName;
    private SearchEngine searchEngine;

    SearchEnginesList(
            String searchEngineValue,
            SearchEngine searchEngine
    ) {
        this.searchEngineName = searchEngineValue;
        this.searchEngine = searchEngine;
    }

    public String getSearchEngineName() {
        return searchEngineName;
    }

    public SearchEngine getSearchEngine() {
        return searchEngine;
    }
}
