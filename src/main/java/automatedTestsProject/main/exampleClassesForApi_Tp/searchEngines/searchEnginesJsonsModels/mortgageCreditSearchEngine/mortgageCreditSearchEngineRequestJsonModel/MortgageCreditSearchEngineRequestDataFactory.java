package automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines.searchEnginesJsonsModels.mortgageCreditSearchEngine.mortgageCreditSearchEngineRequestJsonModel;

public class MortgageCreditSearchEngineRequestDataFactory {

    private Integer own_contribution = 60000;
    private Integer credit_period = 25;
    private String payments_kind = "fixed";
    private Integer property_value = 280000;
    private Integer credit_value = 250000;

    public MortgageCreditSearchEngineRequestJsonModel getMortgageSearchEngineRequestJsonModel() {

        MortgageCreditSearchEngineRequestJsonModel mortgageCreditSearchEngineRequestJsonModel
                = new MortgageCreditSearchEngineRequestJsonModel();

        mortgageCreditSearchEngineRequestJsonModel.setCredit_period(credit_period);
//        mortgageCreditSearchEngineRequestJsonModel.setPayments_kind(payments_kind);
        mortgageCreditSearchEngineRequestJsonModel.setCredit_value(credit_value);

        return mortgageCreditSearchEngineRequestJsonModel;
    }
}
